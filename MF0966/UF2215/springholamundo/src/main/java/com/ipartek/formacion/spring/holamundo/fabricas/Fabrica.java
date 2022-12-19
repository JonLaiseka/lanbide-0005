package com.ipartek.formacion.spring.holamundo.fabricas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.ipartek.formacion.spring.holamundo.proveedores.Proveedor;
import com.ipartek.formacion.spring.holamundo.salidas.Salida;

public class Fabrica {
	private Salida salida;
	private Proveedor proveedor;
	
	public Fabrica(String configuracion) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Properties p = new Properties();
		p.load(Fabrica.class.getClassLoader().getResourceAsStream(configuracion));
		
		String nombreClaseSalida = p.getProperty("salida");
		String nombreClaseProveedor = p.getProperty("proveedor");
		
		salida = (Salida) Class.forName(nombreClaseSalida).getDeclaredConstructor().newInstance();
		proveedor = (Proveedor) Class.forName(nombreClaseProveedor).getDeclaredConstructor().newInstance();
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public Salida getSalida() {
		return salida;
	}
}
