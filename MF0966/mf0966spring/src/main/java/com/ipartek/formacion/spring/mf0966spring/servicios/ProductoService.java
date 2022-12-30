package com.ipartek.formacion.spring.mf0966spring.servicios;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;

public interface ProductoService {
	public Iterable<Producto> obtenerTodos();

	public Object obtenerPorId(Long id);

	public void borrar(Long id);
}
