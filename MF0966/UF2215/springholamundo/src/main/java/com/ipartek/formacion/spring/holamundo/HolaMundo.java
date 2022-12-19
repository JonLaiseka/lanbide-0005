package com.ipartek.formacion.spring.holamundo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.ipartek.formacion.spring.holamundo.fabricas.Fabrica;
import com.ipartek.formacion.spring.holamundo.proveedores.Proveedor;
import com.ipartek.formacion.spring.holamundo.salidas.Salida;

public class HolaMundo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		Fabrica f = new Fabrica("configuracion.properties");
		Proveedor p = f.getProveedor(); //new ProveedorConsolaInteractivo();
		Salida s = f.getSalida(); //new SalidaConsolaEstandarAdornitos();
		
		//System.out.println("Hola Mundo");
		s.mostrar(p.obtener());
	}

}
