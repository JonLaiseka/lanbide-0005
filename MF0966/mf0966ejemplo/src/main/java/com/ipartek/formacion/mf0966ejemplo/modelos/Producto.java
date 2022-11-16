package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
	
	private Categoria categoria;
}
