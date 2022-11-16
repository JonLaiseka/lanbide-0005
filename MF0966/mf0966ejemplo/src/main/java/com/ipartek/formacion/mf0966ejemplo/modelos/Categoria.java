package com.ipartek.formacion.mf0966ejemplo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	private Long id;
	private String nombre;
	private String descripcion;
}
