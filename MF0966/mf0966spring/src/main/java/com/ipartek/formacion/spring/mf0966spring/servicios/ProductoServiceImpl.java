package com.ipartek.formacion.spring.mf0966spring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;
import com.ipartek.formacion.spring.mf0966spring.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}
	
}
