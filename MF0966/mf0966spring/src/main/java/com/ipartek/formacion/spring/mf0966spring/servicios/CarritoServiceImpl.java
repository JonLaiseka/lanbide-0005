package com.ipartek.formacion.spring.mf0966spring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;
import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;

@Service
public class CarritoServiceImpl implements CarritoService {
	@Autowired
	private ProductoService productoService;
	
	@Override
	public void guardarProductoEnCarrito(Long id, Integer cantidad, Pedido pedido) {
		Producto producto = productoService.obtenerPorId(id);

		if (pedido != null) {
			pedido.guardar(cantidad, producto);
		} else {
			throw new UnsupportedOperationException("¡No se ha encontrado el carrito!");
		}
	}
}
