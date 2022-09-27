package com.ipartek.formacion.mf0967.uf2216.poo.presentacion;

import java.math.BigDecimal;

import com.ipartek.formacion.mf0967.uf2216.poo.pojos.Empleado;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.EmpleadoIndefinido;
import com.ipartek.formacion.mf0967.uf2216.poo.pojos.EmpleadoPorHoras;

public class EmpleadoConsola {
	public static void main(String[] args) {
		Empleado e;
		e = new EmpleadoIndefinido("alkdsj", "alksdjf", "alsdkfj", new BigDecimal("23456"), 14);
		
		System.out.println(e.getSueldoMensual());
		
		Empleado[] empleados = new Empleado[2];
		
		empleados[0] = e;
		empleados[1] = new EmpleadoPorHoras("asdfasdf", "asdfads", "asdfasd", new BigDecimal("34"), 160);
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(Empleado empleado: empleados) {
			System.out.println(empleado.getSueldoMensual());
			total = total.add(empleado.getSueldoMensual());
		}
		
		System.out.println(total);
	}
}
