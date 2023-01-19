package com.ipartek.formacion.spring.mf0968ejemplo.servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Usuario;

@SpringBootTest
class ServiciosTest {
	@Autowired
	private UsuarioService servicio;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@BeforeEach
	void rellenarBaseDeDatos() {
		jdbc.update("DELETE FROM usuarios");
		jdbc.update("DELETE FROM roles");
		
		jdbc.update("INSERT INTO roles (id, nombre) VALUES (1, 'ROLE_ADMIN')");
		jdbc.update("INSERT INTO roles (id, nombre) VALUES (2, 'ROLE_USER')");
		
		jdbc.update("INSERT INTO usuarios (nombre, nivel, email, password, rol_id) VALUES ('Javier', 100, 'javier@email.net', 'contra', 1)");
		jdbc.update("INSERT INTO usuarios (nombre, nivel, email, password, rol_id) VALUES ('Pepe', 1, 'pepe@email.net', 'perez', 2)");
	}
	
	@Test
	void obtenerTodos() {
		List<Usuario> usuarios = servicio.obtenerTodos();

		assertEquals("ROLE_ADMIN", usuarios.get(0).getRol().getNombre());
		assertEquals("ROLE_USER", usuarios.get(1).getRol().getNombre());
	}
	
	@Test
	void obtenerPorEmail() {
		Usuario usuario = servicio.obtenerPorEmail("pepe@email.net");
		
		assertNotNull(usuario);
		assertEquals("Pepe", usuario.getNombre());
		assertEquals("ROLE_USER", usuario.getRol().getNombre());
	}
	
	@Test 
	void excepciones() {
		final Usuario usuario = new Usuario();

		assertThrows(ServiciosException.class, () -> servicio.modificar(usuario));
		
		final Usuario usuarioConId = Usuario.builder().id(1L).build();
		
		assertThrows(ServiciosException.class, () -> servicio.insertar(usuarioConId));
		
		assertThrows(ServiciosException.class, () -> servicio.borrar(5L));
	}
}
