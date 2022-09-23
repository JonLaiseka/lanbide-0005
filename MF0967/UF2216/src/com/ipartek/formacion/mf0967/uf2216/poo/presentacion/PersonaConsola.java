package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;

public class PersonaConsola {
	public static void main(String[] args) {
		Persona p;
		p = new Persona(null, "   Javier Lete   ");
		
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
		
		Persona p3 = new Persona(p2);
		
		p3.setId(5L);
		p3.setNombre("MODIFICADO");
		
		System.out.println("P2");
		System.out.println(p2);
		System.out.println(p2.getId());
		System.out.println(p2.getNombre());
		
		System.out.println("P3");
		System.out.println(p3);
		System.out.println(p3.getId());
		System.out.println(p3.getNombre());
	}
}
