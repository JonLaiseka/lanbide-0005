package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;
import com.ipartek.formacion.mf0966ejemplo.modelos.Rol;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public class DaoMySqlUsuarios implements DaoUsuario {

	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	private static final String SQL_SELECT_EMAIL = "SELECT u.id, u.email, u.password, r.id, r.nombre, r.descripcion, c.id, c.nombre, c.nif, c.email FROM usuarios u JOIN roles r ON r.id = u.roles_id JOIN clientes c ON c.id = u.clientes_id WHERE u.email = ?";
	
	// SINGLETON
	private DaoMySqlUsuarios() {
	}

	private static final DaoMySqlUsuarios INSTANCIA = new DaoMySqlUsuarios();

	public static DaoMySqlUsuarios getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON
	
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

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);
				) {
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			Usuario usuario = null;
			Rol rol = null;
			Cliente cliente = null;
			
			if(rs.next()) {
				cliente = new Cliente(rs.getLong("c.id"), rs.getString("nombre"), rs.getString("nif"), rs.getString("email"));
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), rol, cliente);
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("La aplicación no puede realizar esta operación", e);
		}
	}
	
	
}
