package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Factura extends Pedido {
	private Long id;
	private String codigo;
	private LocalDate fecha;

	private Cliente cliente;
	private Empleado empleado;
}
