package com.ipartek.formacion.spring.mf0966spring.servicios;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;

public interface CarritoService {

	void guardarProductoEnCarrito(Long id, Integer cantidad, Pedido pedido);

}