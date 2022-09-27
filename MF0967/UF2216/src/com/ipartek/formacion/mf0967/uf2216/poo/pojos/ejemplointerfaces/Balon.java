package com.ipartek.formacion.mf0967.uf2216.poo.pojos.ejemplointerfaces;

public class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
	
}
