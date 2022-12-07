package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido.Linea;

public class DaoMySqlFactura implements Dao<Factura> {

	private static final String SQL_INSERT = "INSERT INTO facturas (codigo, fecha, clientes_id, empleados_id) VALUES (?,?,?,?)";
	private static final String SQL_INSERT_LINEA = "INSERT INTO facturas_has_productos (facturas_id, productos_id, cantidad) VALUES (?,?,?)";
	private static final String SQL_NUEVO_CODIGO = "call nuevo_codigo(?)";

	// SINGLETON
	private DaoMySqlFactura() {}
	private static final Dao<Factura> INSTANCIA = new DaoMySqlFactura();
	public static Dao<Factura> getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public synchronized Factura insertar(Factura factura) {
		try (Connection con = getConexion()) {
			factura.setFecha(LocalDate.now());
			factura.setCodigo(nuevoCodigoFactura(con, factura));
			
			return insertarImpl(factura, con);
		} catch(Exception e) {
			throw new AccesoDatosException("No se ha podido insertar la factura", e);
		}
	}

	private String nuevoCodigoFactura(Connection con, Factura factura) {
		try (CallableStatement cst = con.prepareCall(SQL_NUEVO_CODIGO)) {
			cst.setString(1, String.valueOf(factura.getFecha().getYear()));
			
			ResultSet rs = cst.executeQuery();
			
			rs.next();
			
			return rs.getString(1);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir el nuevo código", e);
		}
	}
	
	private Factura insertarImpl(Factura factura, Connection con) {
		try (PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			pst.setString(1, factura.getCodigo());
			pst.setDate(2, java.sql.Date.valueOf(factura.getFecha()));
			pst.setLong(3, factura.getCliente().getId());
			pst.setLong(4, factura.getEmpleado().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			rs.next();

			factura.setId(rs.getLong(1));

			insertarLineasImpl(factura, con);

			con.commit();

		} catch (SQLException e) {
			deshacerTransaccion(con);
			
			throw new AccesoDatosException("Se ha cancelado la transacción", e);
		}
		
		return factura;
	}

	private void insertarLineasImpl(Factura factura, Connection con) throws SQLException {
		try (PreparedStatement pstLinea = con.prepareStatement(SQL_INSERT_LINEA)) {
			pstLinea.setLong(1, factura.getId());

			for (Linea linea : factura.getLineas()) {
				pstLinea.setLong(2, linea.getProducto().getId());
				pstLinea.setInt(3, linea.getCantidad());

				pstLinea.executeUpdate();
			}
		}
	}

	private void deshacerTransaccion(Connection con) {
		try {
			con.rollback();
		} catch (SQLException ex) {
			throw new AccesoDatosException("No se ha podido deshacer la transacción", ex);
		}
	}


}
