package com.ipartek.formacion.spring.holamundo.proveedores;

import org.springframework.stereotype.Component;

@Component
public class ProveedorHolaMundoConstante implements Proveedor {

	@Override
	public String obtener() {
		return "Hola Mundo";
	}

}
