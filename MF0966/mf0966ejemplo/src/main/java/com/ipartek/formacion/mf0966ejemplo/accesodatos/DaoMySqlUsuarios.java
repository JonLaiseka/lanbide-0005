package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public class DaoMySqlUsuarios implements Dao<Usuario> {

	private static final String URL = "jdbc:mysql://localhost:3306/mf0966ejemplo";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	
	// SINGLETON
	private DaoMySqlUsuarios() {
	}

	private static final DaoMySqlUsuarios INSTANCIA = new DaoMySqlUsuarios();

	public static DaoMySqlUsuarios getInstancia() {
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
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			final ArrayList<Usuario> usuarios = new ArrayList<>();
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password")));
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("La aplicación no puede realizar esta operación", e);
		}
	}
	
	
}
