package com.ipartek.formacion.mf0967.uf2216.poo.pojos.ejemplointerfaces;

public class Naranja extends Fruto implements Rodable, Comestible {
	private boolean limpia = true;
	
	@Override
	public void comer() {
		if(limpia) {
			System.out.println("Ñam... que rica");
		} else {
			System.out.println("PUAJJJJJ está sucia");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		limpia = false;
	}

}
