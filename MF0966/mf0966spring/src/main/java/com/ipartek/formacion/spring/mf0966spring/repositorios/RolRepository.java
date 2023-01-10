package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {
	Rol findByNombre(String nombre);
}
