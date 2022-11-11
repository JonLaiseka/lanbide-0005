package com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

public class DaoMySqlProducto implements Dao<Producto> {
	private static final String URL = "jdbc:mysql://localhost:3306/mf0966";
	private static final String USER = "mf0966app";
	private static final String PASSWORD = "mf0966admin";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, cantidad, caducidad) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?,precio=?,cantidad=?,caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido instanciar el driver de base de datos");
		}
	}

	// SINGLETON
	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	private static Connection getConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar con la base de datos", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		final Collection<Producto> productos = new ArrayList<>();

		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				productos.add(new Producto(rs.getLong("id"), rs.getString("nombre"),
						rs.getDate("caducidad").toLocalDate(), rs.getBigDecimal("precio"), rs.getInt("cantidad")));
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido recuperar los registros", e);
		}

		return productos;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		Producto producto = null;

		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					producto = new Producto(rs.getLong("id"), rs.getString("nombre"),
							rs.getDate("caducidad").toLocalDate(), rs.getBigDecimal("precio"), rs.getInt("cantidad"));
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido recuperar el registro id " + id, e);
		}

		return producto;
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setInt(3, producto.getCantidad());
			pst.setDate(4, Date.valueOf(producto.getCaducidad()));

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException("Ha habido un problema con la inserción");
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro", e);
		}

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setInt(3, producto.getCantidad());
			pst.setObject(4, Date.valueOf(producto.getCaducidad()));
			pst.setLong(5, producto.getId());

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException("Ha habido un problema con la modificación");
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro", e);
		}

		return producto;
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException("Ha habido un problema con el borrado");
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro", e);
		}
	}
}
