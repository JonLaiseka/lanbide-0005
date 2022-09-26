package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Cliente;

public class ClienteConsola {

	public static void main(String[] args) {
		Cliente c = new Cliente("Pepe", "Pérez", "87654321A");
		
		System.out.println(c.getInformacion());
		
		c.setId(1L);
		c.setNombre("Javier");
		c.setApellidos("Lete");
		c.setNif("12345678A");
		
		System.out.println(c.getInformacion());
		System.out.println(c.getNif());
	}

}
