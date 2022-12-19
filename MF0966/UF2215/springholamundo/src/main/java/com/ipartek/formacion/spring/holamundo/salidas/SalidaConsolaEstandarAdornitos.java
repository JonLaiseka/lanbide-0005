package com.ipartek.formacion.spring.holamundo.salidas;

import org.springframework.stereotype.Component;

@Component
public class SalidaConsolaEstandarAdornitos implements Salida {

	@Override
	public void mostrar(String texto) {
		System.out.println("<<<<" + texto + ">>>>");
	}

}
