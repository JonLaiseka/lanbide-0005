package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
	private Long id;
	private String nombre;
	private String descripcion;
	
	private final Set<Usuario> usuarios = new HashSet<>();
}
