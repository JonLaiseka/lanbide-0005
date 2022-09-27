package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.math.BigDecimal;

public abstract class Empleado extends Persona {
	private String numeroSeguridadSocial;

	public Empleado(Long id, String nombre, String apellidos, String numeroSeguridadSocial) {
		super(id, nombre, apellidos);
		setNumeroSeguridadSocial(numeroSeguridadSocial);
	}

	public Empleado(String nombre, String apellidos, String numeroSeguridadSocial) {
		this(null, nombre, apellidos, numeroSeguridadSocial);
	}

	public abstract BigDecimal getSueldoMensual();
	
	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}
}
