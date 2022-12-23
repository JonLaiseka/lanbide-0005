package com.ipartek.formacion.spring.mf0966spring.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String nif;

	@ManyToOne
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
