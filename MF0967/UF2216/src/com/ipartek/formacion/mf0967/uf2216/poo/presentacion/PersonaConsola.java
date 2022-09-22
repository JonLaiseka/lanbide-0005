package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;

public class PersonaConsola {
	public static void main(String[] args) {
		Persona p;
		p = new Persona(-1L, "   ");
		
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		
		Persona p2 = p;
		
		p2.setNombre("Pepe");
		
		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getNombre());
	 	
		System.out.println(p2);
		System.out.println(p2.getId());
		System.out.println(p2.getNombre());
		
		p2 = new Persona();
		p2.setId(1L);
		p2.setNombre("Pepe");
		
		System.out.println(p2);
		System.out.println(p2.getId());
		System.out.println(p2.getNombre());
		
		System.out.println(p == p2); // Comparación de punteros (¿Son el mismo? "dos referencias mismo objeto")
		System.out.println(p.equals(p2)); // Comparación de contenido (¿Son iguales? "gemelos")
	}
}
