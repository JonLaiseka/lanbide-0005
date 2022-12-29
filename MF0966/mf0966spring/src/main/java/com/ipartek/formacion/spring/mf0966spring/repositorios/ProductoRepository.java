package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;

import java.util.Set;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	@Query("from Producto p join fetch p.categoria")
	public Set<Producto> findAll();
}
