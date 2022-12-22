package com.ipartek.formacion.hibernate.hibernatedao.entidades;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.hibernate.hibernatedao.dal.Dao;
import com.ipartek.formacion.hibernate.hibernatedao.dal.DaoHibernateColectivo;

public class ColectivoTest {
	private static final Dao<Colectivo> dao = DaoHibernateColectivo.getInstancia();
	
	private static final Colectivo COLECTIVO_1 = Colectivo.builder().id(1L).nombre("Administradores").build();
	private static final Colectivo COLECTIVO_2 = Colectivo.builder().id(2L).nombre("Usuarios").build();
	private static final Colectivo COLECTIVO_NUEVO = Colectivo.builder().nombre("Nuevo").build();
	private static final Colectivo COLECTIVO_MODIFICADO = Colectivo.builder().id(2L).nombre("Modificado").build();
	
	@BeforeClass
	public static void inicializacion() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedao", "root", "admin");
		Statement st = con.createStatement();
		
		st.executeUpdate("INSERT INTO colectivos (nombre) VALUES ('Administradores'), ('Usuarios')");
	}
	
	@Test
    public void obtenerTodosTest()
    {
        Iterable<Colectivo> colectivos = dao.obtenerTodos();
        
        Iterator<Colectivo> iterator = colectivos.iterator();
        
        Colectivo colectivo = iterator.next();
        
        assertEquals(COLECTIVO_1, colectivo);
        
        colectivo = iterator.next();
        
        assertEquals(COLECTIVO_2, colectivo);
    }
    
    @Test
    public void obtenerPorIdTest() {
    	Colectivo p = dao.obtenerPorId(5L);
    	
    	assertNull(p);
    	
    	p = dao.obtenerPorId(1L);
    	
    	assertEquals(COLECTIVO_1, p);
    }
    
    @Test
    public void insertarTest() {
    	Colectivo p = dao.insertar(COLECTIVO_NUEVO);
    	
    	assertEquals(COLECTIVO_NUEVO, dao.obtenerPorId(p.getId()));
    }
    
    @Test
    public void modificarTest() {
    	dao.modificar(COLECTIVO_MODIFICADO);
    	
    	Colectivo p = dao.obtenerPorId(COLECTIVO_MODIFICADO.getId());
    	
    	assertEquals(COLECTIVO_MODIFICADO, p);
    }
    
    @Test
    public void borrarTest() {
    	assertNotNull(dao.obtenerPorId(1L));
    	
    	dao.borrar(1L);
    	
    	assertNull(dao.obtenerPorId(1L));
    }
}
