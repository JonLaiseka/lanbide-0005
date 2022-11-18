package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
	private Long id;
	private String codigo;
	private LocalDate fecha;

	private Cliente cliente;
	private Empleado empleado;

	private Set<Linea> lineas = new HashSet<>();

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Linea {
		private Factura factura;
		private Producto producto;
		private Integer cantidad;
	}
}
