package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

public class NumberConsola {
	public static void main(String[] args) {
		Number[] numeros = new Number[2];
		
		numeros[0] = 2; //new Integer(2);
		numeros[1] = 5.6; //new Double(5.6);
		
		for(Number n: numeros) {
			System.out.println(n.doubleValue());
		}
	}
}
