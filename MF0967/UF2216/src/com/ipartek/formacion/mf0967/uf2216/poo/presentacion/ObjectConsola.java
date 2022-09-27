package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Cliente;

public class ObjectConsola {
	public static void main(String[] args) {
		Object o = new Object();
		
		System.out.println(o);
		
		Cliente c = new Cliente("asdf", "asdfas", "asdfas");

		o = c;
		
		System.out.println(c.getInformacion());
		System.out.println(c.toString());
		System.out.println(c);
		
		Cliente c1 = new Cliente("asdf", "asdfas", "asdfas");
		Cliente c2 = new Cliente("asdf", "asdfas", "asdfas");
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		
		System.out.println(c1.getClass().getName());
		System.out.println(Integer.toHexString(c1.hashCode()));
		System.out.println(Integer.toHexString(c2.hashCode()));
	}
}
