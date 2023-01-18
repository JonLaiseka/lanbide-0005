package com.ipartek.formacion.spring.mf0968ejemplo.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Rol;
import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Usuario;

@SpringBootTest
class RepositoryTest {
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private RolRepository repoRol;
	
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
	void findAll() {
		List<Usuario> usuarios = repoUsuario.findAll();

		assertEquals("ROLE_ADMIN", usuarios.get(0).getRol().getNombre());
		assertEquals("ROLE_USER", usuarios.get(1).getRol().getNombre());
	}
	
	@Test
	void findByEmail() {
		Optional<Usuario> usuario = repoUsuario.findByEmail("pepe@email.net");
		
		assertTrue(usuario.isPresent());
		assertEquals("Pepe", usuario.get().getNombre());
		assertEquals("ROLE_USER", usuario.get().getRol().getNombre());
	}
	
	@Test
	void findByRol() {
		List<Usuario> usuarios = repoUsuario.findByRol("ROLE_ADMIN");
		
		assertEquals(1, usuarios.size());
		
		assertEquals("Javier", usuarios.get(0).getNombre());
		assertEquals("ROLE_ADMIN", usuarios.get(0).getRol().getNombre());
	}
	
	@Test
	void rolFindByNombre() {
		Optional<Rol> rol = repoRol.findByNombre("ROLE_USER");
		
		assertTrue(rol.isPresent());
		
		assertEquals(2L, rol.get().getId());
	}
}
