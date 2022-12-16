package com.ipartek.formacion.mf0966ejemplo.modelos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empleado {
	private Long id;
	private String nombre;
	private String nif;

	private Empleado jefe;

	public Empleado(Long id, String nombre, String nif, Empleado jefe) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setJefe(jefe);
	}

	public void setId(Long id) {
		if (id != null && jefe != null && jefe.getId() != null && jefe.getId() == id) {
			throw new IllegalArgumentException("Un empleado no puede ser jefe de sí mismo");
		}

		this.id = id;
	}

	public void setJefe(Empleado jefe) {
		if (this.getId() != null && jefe != null && jefe.getId() != null && jefe.getId() == this.getId()) {
			throw new IllegalArgumentException("Un empleado no puede ser jefe de sí mismo");
		}

		this.jefe = jefe;
	}

}
