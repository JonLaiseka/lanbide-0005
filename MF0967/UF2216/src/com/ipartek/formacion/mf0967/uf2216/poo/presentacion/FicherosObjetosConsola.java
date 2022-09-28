package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Cliente;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Espacio;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Persona;

public class FicherosObjetosConsola {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Espacio e = new Espacio("Bilbao");
		
		e.entrar(new Persona());
		e.entrar(new Persona("lkajsdlfkajs"));
		e.entrar(new Cliente("lkajsdflk", "ljasldkfja", "lkajslkfjas"));
		
		FileOutputStream fos = new FileOutputStream("datos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(e);
		
		oos.close();
		
		FileInputStream fis = new FileInputStream("datos.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Espacio espacio = (Espacio) ois.readObject();
		
		for(Persona p: espacio.getPersonas()) {
			System.out.println(p);
		}
		
		ois.close();
	}
}
