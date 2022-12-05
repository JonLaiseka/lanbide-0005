package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido.Linea;

public class DaoMySqlFactura implements Dao<Factura> {

	private static final String SQL_INSERT = "INSERT INTO factura (codigo, fecha, clientes_id, empleados_id) VALUES (?,?,?,?)";
	private static final String SQL_INSERT_LINEA = "INSERT INTO facturas_has_productos (facturas_id, productos_id, cantidad) VALUES (?,?,?)";

	// SINGLETON
	private DaoMySqlFactura() {}
	private static final Dao<Factura> INSTANCIA = new DaoMySqlFactura();
	public static Dao<Factura> getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Factura insertar(Factura factura) {
		try (Connection con = getConexion()) {
			return insertarImpl(factura, con);
		} catch(Exception e) {
			throw new AccesoDatosException("No se ha podido insertar la factura", e);
		}
	}

	private Factura insertarImpl(Factura factura, Connection con) {
		try (PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);

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
