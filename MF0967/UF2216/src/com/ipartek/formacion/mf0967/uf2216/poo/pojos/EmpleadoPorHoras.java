package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.math.BigDecimal;

public class EmpleadoPorHoras extends Empleado {
	private BigDecimal precioHora;
	private Integer numeroHorasMensuales;
	
	public EmpleadoPorHoras(Long id, String nombre, String apellidos, String numeroSeguridadSocial,
			BigDecimal precioHora, Integer numeroHorasMensuales) {
		super(id, nombre, apellidos, numeroSeguridadSocial);
		this.precioHora = precioHora;
		this.numeroHorasMensuales = numeroHorasMensuales;
	}
	
	public EmpleadoPorHoras(String nombre, String apellidos, String numeroSeguridadSocial,
			BigDecimal precioHora, Integer numeroHorasMensuales) {
		this(null, nombre, apellidos, numeroSeguridadSocial, precioHora, numeroHorasMensuales);
	}
	
	public BigDecimal getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(BigDecimal precioHora) {
		this.precioHora = precioHora;
	}
	public Integer getNumeroHorasMensuales() {
		return numeroHorasMensuales;
	}
	public void setNumeroHorasMensuales(Integer numeroHorasMensuales) {
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return precioHora.multiply(new BigDecimal(numeroHorasMensuales)).setScale(2);
	}
	
	
}
