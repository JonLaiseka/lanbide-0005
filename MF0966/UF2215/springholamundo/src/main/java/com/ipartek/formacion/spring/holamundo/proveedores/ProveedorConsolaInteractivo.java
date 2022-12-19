package com.ipartek.formacion.spring.holamundo.proveedores;

import java.util.Scanner;

public class ProveedorConsolaInteractivo implements Proveedor {

	@Override
	public String obtener() {
		System.out.print("Dime tu nombre: ");
		@SuppressWarnings("resource")
		String nombre = new Scanner(System.in).nextLine();
		return "Hola " + nombre;
	}

}
