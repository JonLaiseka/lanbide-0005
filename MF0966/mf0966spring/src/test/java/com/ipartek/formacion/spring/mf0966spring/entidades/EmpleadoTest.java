package com.ipartek.formacion.spring.mf0966spring.entidades;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.spring.mf0966spring.repositorios.EmpleadoRepository;

@SpringBootTest
public class EmpleadoTest {
	@Autowired
	private EmpleadoRepository repo;
	
	@Test
	public void obtenerTodos() {
		System.out.println(repo.obtenerTodos());
	}

	@Test
	public void obtenerPorId() {
		System.out.println(repo.obtenerPorId(1L));
	}
	
	@Test
	public void insertar() {
		Empleado empleadoNuevo = Empleado.builder().nombre("Nuevo").nif("12345678Z").build();
		repo.insertar(empleadoNuevo);
	}

	@Test
	public void modificar() {
		Empleado empleadoModificado = Empleado.builder().id(16L).nombre("MODIFICADO").nif("12345678Z").build();
		repo.modificar(empleadoModificado);
	}
	
	@Test
	public void borrar() {
		repo.borrar(17L);
	}
}
