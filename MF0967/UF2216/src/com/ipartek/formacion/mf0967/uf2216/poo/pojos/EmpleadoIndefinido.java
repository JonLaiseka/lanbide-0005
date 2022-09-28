package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpleadoIndefinido extends Empleado {
	private static final long serialVersionUID = 1L;
	
	private BigDecimal sueldoAnual;
	private Integer numeroPagas;
	
	public EmpleadoIndefinido(Long id, String nombre, String apellidos, String numeroSeguridadSocial,
			BigDecimal sueldoAnual, Integer numeroPagas) {
		super(id, nombre, apellidos, numeroSeguridadSocial);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}
	
	public EmpleadoIndefinido(String nombre, String apellidos, String numeroSeguridadSocial,
			BigDecimal sueldoAnual, Integer numeroPagas) {
		this(null, nombre, apellidos, numeroSeguridadSocial, sueldoAnual, numeroPagas);
	}
	
	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}
	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}
	public Integer getNumeroPagas() {
		return numeroPagas;
	}
	public void setNumeroPagas(Integer numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		sueldoAnual = sueldoAnual.setScale(2);
		return sueldoAnual.divide(new BigDecimal(numeroPagas), RoundingMode.HALF_UP);
	}
	
	
}
