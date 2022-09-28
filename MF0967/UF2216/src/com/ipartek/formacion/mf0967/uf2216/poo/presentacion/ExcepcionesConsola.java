package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.PojosException;

import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.*;

public class ExcepcionesConsola {

	public static void main(String[] args) {
		Persona p = new Persona();

		boolean correcto = false;
		
		do {
			try {
				p.setId((long) gInt("Dime un ID"));
				correcto = true;
			} catch (PojosException e) {
				ple(e.getMessage());
			}
		} while (!correcto);
		
		pl(p);
	}

}
