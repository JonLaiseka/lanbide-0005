package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

class DaoMySqlEmpleadoTest {
	private DaoMySqlEmpleadoTest() {}
	private Dao<Empleado> dao = DaoMySqlEmpleado.getInstancia();
	
	@Test
	void obtenerTodos() {
		ArrayList<Empleado> empleados = (ArrayList<Empleado>) dao.obtenerTodos();
		
		assertEquals(5, empleados.size());
		
		assertEquals("Jefazo", empleados.get(4).getJefe().getNombre());
		
		assertEquals("Empleado2", empleados.get(3).getJefe().getNombre());
		
	}
	
	@Test
	void obtenerPorId() {
		Empleado e = dao.obtenerPorId(4L);
		
		assertNotNull(e);
		
		assertEquals("Empleado4", e.getNombre());
		
		assertEquals("Empleado2", e.getJefe().getNombre());
		
		assertEquals("Jefazo", e.getJefe().getJefe().getNombre());
		
		assertNull(e.getJefe().getJefe().getJefe());
		
		System.out.println(e);
	}
}
