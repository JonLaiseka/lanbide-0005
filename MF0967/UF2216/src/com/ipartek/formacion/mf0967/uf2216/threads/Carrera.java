package com.ipartek.formacion.mf0967.uf2216.threads;

public class Carrera {
	public static void main(String[] args) {
		Corredor c1 = new Corredor("c1");
		Corredor c2 = new Corredor("c2");
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
	}
}
