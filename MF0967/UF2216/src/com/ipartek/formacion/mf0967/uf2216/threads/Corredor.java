package com.ipartek.formacion.mf0967.uf2216.threads;

import java.util.Random;

public class Corredor implements Runnable {
	private String dorsal;
	private int posicion;
	
	public Corredor(String dorsal) {
		this.dorsal = dorsal;
	}
	
	@Override
	public void run() {
		for(posicion = 1; posicion <= 10; posicion++) {
			System.out.println(dorsal + ":" + posicion);
			
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {}
		}
	}
}
