package com.ipartek.formacion.spring.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.holamundo.proveedores.Proveedor;
import com.ipartek.formacion.spring.holamundo.salidas.Salida;

@SpringBootApplication
public class SpringholamundoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringholamundoApplication.class, args);
	}

	@Autowired
	private Proveedor p;
	
	@Autowired
	private Salida s;
	
	@Override
	public void run(String... args) throws Exception {
		s.mostrar(p.obtener());
	}

}
