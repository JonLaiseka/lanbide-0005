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

	@Override
	public Producto obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		if(producto.getId() != null) {
			throw new ServiciosException("No se puede insertar un elemento con Id");
		}
		return repo.save(producto);
	}
	
	public Producto modificar(Producto producto) {
		if(producto.getId() == null) {
			throw new ServiciosException("No se puede modificar un elemento sin saber su Id");
		}
		return repo.save(producto);
	}
	
	
}
