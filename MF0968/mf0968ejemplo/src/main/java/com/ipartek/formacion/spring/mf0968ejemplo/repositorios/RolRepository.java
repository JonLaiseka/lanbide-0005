package com.ipartek.formacion.spring.mf0968ejemplo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Rol;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByNombre(String nombre);
}
