package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlProducto implements Dao<Producto> {
	private static final String URL = "jdbc:mysql://localhost:3306/mf0966ejemplo";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	private static final String SQL_SELECT_ID = "SELECT p.id, p.nombre, p.precio, p.descripcion, c.id, c.nombre, c.descripcion FROM productos p, categorias c WHERE p.categorias_id = c.id AND p.id = ?";
	
	// SINGLETON
	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido encontrar el driver");
		}
	}

	private Connection getConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cargar el driver", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;
			
			if(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria);
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	
	
}
