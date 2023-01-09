package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
