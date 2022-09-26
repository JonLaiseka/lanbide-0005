package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Cliente;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Espacio;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;

public class HerenciaConsola {
	public static void main(String[] args) {
		Cliente c = new Cliente("Pepe", "Pérez", "87654321A");
		// Casting implícito
		Persona p = c;
		
		System.out.println(p.getNombreCompleto());
		System.out.println(p.getInformacion());
		
		Espacio e = new Espacio("Herencia");
		
		e.entrar(new Persona(null, "Juan", "González"));
		e.entrar(c);
		
		Cliente cliente;
		
		for(Persona persona: e.getPersonas()) {
			System.out.println(persona.getInformacion());
			
			if(persona instanceof Cliente) {
				cliente = (Cliente) persona;
				System.out.println(cliente.getNif());
			}
			
		}
	}
}
