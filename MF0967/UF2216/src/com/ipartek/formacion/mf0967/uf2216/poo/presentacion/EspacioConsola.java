package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Espacio;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;

public class EspacioConsola {
	public static void main(String[] args) {
		Espacio e = new Espacio("Bilbao");
		
		Persona p = new Persona("Javier");
		Persona noMeQuedo = new Persona("No me quedo");
		
		e.entrar(p);
		e.entrar(new Persona("Pepe"));
		e.entrar(noMeQuedo);
		e.entrar(new Persona("Juan"));
		e.salir(noMeQuedo);
		
		for(Persona persona: e.getPersonas()) {
			System.out.println(persona.getInformacion());
		}
	}
}
