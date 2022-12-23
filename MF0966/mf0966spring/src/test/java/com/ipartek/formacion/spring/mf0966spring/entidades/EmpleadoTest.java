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
		System.out.println(repo.findAll());
	}

	@Test
	public void obtenerPorId() {
		System.out.println(repo.findById(1L));
		System.out.println(repo.findById(2L));
		System.out.println(repo.findById(Long.MAX_VALUE));
	}

	@Test
	public void insertar() {
		Empleado empleadoNuevo = Empleado.builder().nombre("Nuevo").nif("12345678Z")
				.jefe(Empleado.builder().id(1L).build()).build();
		System.out.println(repo.save(empleadoNuevo));
	}

	@Test
	public void modificar() {
		Empleado empleadoModificado = Empleado.builder().id(19L).nombre("MODIFICADISIMO").nif("12345678Z").build();
		System.out.println(repo.save(empleadoModificado));
	}

	@Test
	public void borrar() {
		try {
			repo.deleteById(20L);
		} catch (Exception e) {

		}
	}
	
	@Test
	public void findByNombre() {
		System.out.println("POR NOMBRE: " + repo.findByNombre("Empleado3"));
	}
}
