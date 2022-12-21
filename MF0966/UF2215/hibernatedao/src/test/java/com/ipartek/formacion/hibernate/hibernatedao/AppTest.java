package com.ipartek.formacion.hibernate.hibernatedao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.hibernate.hibernatedao.dal.Dao;
import com.ipartek.formacion.hibernate.hibernatedao.dal.DaoHibernatePersona;
import com.ipartek.formacion.hibernate.hibernatedao.entidades.Persona;

import java.sql.*;

public class AppTest 
{
	private static final LocalDate FECHA_TEST = LocalDate.of(2022, 12, 21);
	
	private static final Persona PERSONA_1 = new Persona(1L, "Javier", FECHA_TEST);
	private static final Persona PERSONA_2 = new Persona(2L, "Pepe", FECHA_TEST);
	private static final Persona PERSONA_NUEVO = new Persona(null, "Nuevo", FECHA_TEST);
	private static final Persona PERSONA_MODIFICADO = new Persona(2L, "Modificado", FECHA_TEST);
	
	private static final Dao<Persona> dao = DaoHibernatePersona.getInstancia();
	
	@BeforeClass
	public static void inicializacion() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedao", "root", "admin");
		Statement st = con.createStatement();
		
		st.executeUpdate("TRUNCATE personas");
		
		st.executeUpdate("INSERT INTO personas VALUES (null, '2022-12-21', 'Javier')");
		st.executeUpdate("INSERT INTO personas VALUES (null, '2022-12-21', 'Pepe')");
	}
	
	
    @Test
    public void obtenerTodos()
    {
        Iterable<Persona> personas = dao.obtenerTodos();
        
        Iterator<Persona> iterator = personas.iterator();
        
        Persona persona = iterator.next();
        
        assertEquals(PERSONA_1, persona);
        
        persona = iterator.next();
        
        assertEquals(PERSONA_2, persona);
    }
    
    @Test
    public void obtenerPorIdTest() {
    	Persona p = dao.obtenerPorId(5L);
    	
    	assertNull(p);
    	
    	p = dao.obtenerPorId(1L);
    	
    	assertEquals(PERSONA_1, p);
    }
    
    @Test
    public void insertarTest() {
    	Persona p = dao.insertar(PERSONA_NUEVO);
    	
    	assertEquals(PERSONA_NUEVO, dao.obtenerPorId(p.getId()));
    }
    
    @Test
    public void modificarTest() {
    	dao.modificar(PERSONA_MODIFICADO);
    	
    	Persona p = dao.obtenerPorId(PERSONA_MODIFICADO.getId());
    	
    	assertEquals(PERSONA_MODIFICADO, p);
    }
    
    @Test
    public void borrarTest() {
    	assertNotNull(dao.obtenerPorId(1L));
    	
    	dao.borrar(1L);
    	
    	assertNull(dao.obtenerPorId(1L));
    }
}
