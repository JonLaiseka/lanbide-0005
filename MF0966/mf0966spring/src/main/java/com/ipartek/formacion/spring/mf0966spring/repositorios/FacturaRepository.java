package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
	@Query("select f.codigo from Factura f where f.codigo like :anno% order by f.codigo desc limit 1")
	String buscarUltimoCodigo(String anno);
}
