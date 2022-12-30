package com.ipartek.formacion.spring.mf0966spring.servicios;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;

public interface ProductoService {
	public Iterable<Producto> obtenerTodos();

	public Producto obtenerPorId(Long id);

	public void borrar(Long id);

	public Producto insertar(Producto producto);
	
	public Producto modificar(Producto producto);
}
