package com.ipartek.formacion.spring.mf0966spring.entidades;

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
