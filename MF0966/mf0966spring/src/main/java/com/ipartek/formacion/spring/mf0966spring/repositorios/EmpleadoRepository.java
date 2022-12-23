package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	public Empleado findByNombre(String nombre);
	
	@Query("from Empleado where nombre = ?")
	public Empleado getByNombre(String nombre);
}
