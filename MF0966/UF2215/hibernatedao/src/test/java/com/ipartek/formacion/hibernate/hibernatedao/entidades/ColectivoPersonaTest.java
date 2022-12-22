package com.ipartek.formacion.hibernate.hibernatedao.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.hibernate.hibernatedao.dal.Dao;
import com.ipartek.formacion.hibernate.hibernatedao.dal.DaoHibernateColectivo;
import com.ipartek.formacion.hibernate.hibernatedao.dal.DaoHibernatePersona;

public class ColectivoPersonaTest {
	private static final Dao<Colectivo> daoColectivo = DaoHibernateColectivo.getInstancia();
	private static final Dao<Persona> daoPersona = DaoHibernatePersona.getInstancia();
	
	@BeforeClass
	public static void inicializacion() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedao", "root", "admin");
		Statement st = con.createStatement();
		
		st.executeUpdate("INSERT INTO colectivos (nombre) VALUES ('Administradores'), ('Usuarios')");
		st.executeUpdate("INSERT INTO personas (nombre, fecha_nacimiento, colectivo_id) VALUES ('Javier', '2022-12-21', 1), ('Pepe', '2022-12-21', 2), ('Juan', '2022-12-21', 2)");
	}
	
	@Test
	public void obtenerTodosColectivoTest() {
		Iterable<Colectivo> colectivos = daoColectivo.obtenerTodos();
		
		System.out.println(colectivos);
		
		for(Colectivo colectivo: colectivos) {
			System.out.println(colectivo);
			// System.out.println(colectivo.getPersonas()); // ERROR LAZY
		}
	}
	
	@Test
	public void obtenerPorIdColectivoTest() {
		Colectivo colectivo = daoColectivo.obtenerPorId(2L);
		
		System.out.println(colectivo);
		System.out.println(colectivo.getPersonas());
	}
	
	@Test
	public void obtenerTodosPersonaTest() {
		Iterable<Persona> personas = daoPersona.obtenerTodos();
		
		System.out.println("PERSONAS");
		System.out.println(personas);
		
		Iterator<Persona> iterator = personas.iterator();
		
		Persona persona;
		
		while(iterator.hasNext()) {
			persona = iterator.next();
			System.out.println(persona);
			System.out.println(persona.getColectivo());
		}
		
	}
	
	@Test
	public void obtenerPorIdPersonaTest() {
		Persona persona = daoPersona.obtenerPorId(1L);
		
		System.out.println("PERSONA POR ID");
		System.out.println(persona);
		System.out.println(persona.getColectivo());
	}
}
