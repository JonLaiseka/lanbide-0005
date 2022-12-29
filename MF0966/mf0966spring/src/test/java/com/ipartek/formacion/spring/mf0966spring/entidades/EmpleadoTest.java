package com.ipartek.formacion.spring.mf0966spring.entidades;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.spring.mf0966spring.repositorios.EmpleadoRepository;

@SpringBootTest
class EmpleadoTest {
	@Autowired
	private EmpleadoRepository repo;

	@Test
	void obtenerTodos() {
		System.out.println(repo.findAll());
	}

	@Test
	void obtenerPorId() {
		System.out.println(repo.findById(1L));
		System.out.println(repo.findById(2L));
		System.out.println(repo.findById(Long.MAX_VALUE));
	}

	@Test
	void insertar() {
		Empleado empleadoNuevo = Empleado.builder().nombre("Nuevo").nif("12345678Z")
				.jefe(Empleado.builder().id(1L).build()).build();
		System.out.println(repo.save(empleadoNuevo));
	}

	@Test
	void modificar() {
		Empleado empleadoModificado = Empleado.builder().id(19L).nombre("MODIFICADISIMO").nif("12345678Z").build();
		System.out.println(repo.save(empleadoModificado));
	}

	@Test
	void borrar() {
		try {
			repo.deleteById(20L);
		} catch (Exception e) {

		}
	}
	
	@Test
	void findByNombre() {
		System.out.println("POR NOMBRE: " + repo.findByNombre("Empleado3"));
	}
}
