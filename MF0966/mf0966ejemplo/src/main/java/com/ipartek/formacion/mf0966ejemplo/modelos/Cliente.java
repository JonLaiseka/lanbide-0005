package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	private Long id;
	private String nombre;
	private String nif;
	private String email;

	private final Set<Factura> facturas = new HashSet<>();
}
