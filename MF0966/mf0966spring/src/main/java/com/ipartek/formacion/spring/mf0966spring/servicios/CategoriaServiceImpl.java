package com.ipartek.formacion.spring.mf0966spring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0966spring.entidades.Categoria;
import com.ipartek.formacion.spring.mf0966spring.repositorios.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public Iterable<Categoria> obtenerTodas() {
		return repo.findAll();
	}

}
