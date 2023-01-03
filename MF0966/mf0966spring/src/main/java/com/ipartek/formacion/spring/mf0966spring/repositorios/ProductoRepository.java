package com.ipartek.formacion.spring.mf0966spring.repositorios;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	@Query("from Producto p join fetch p.categoria order by p.id")
	public Set<Producto> findAll();
	
	@Query("from Producto p join fetch p.categoria where p.id = :id")
	public Optional<Producto> findById(Long id);
}
