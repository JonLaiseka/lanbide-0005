package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	// Enumeración
	public static enum Formato {
		SIN_FORMATO, MAYUSCULAS, MINUSCULAS
	}

	// Constantes
	public static final String NOMBRE_POR_DEFECTO = "ANÓNIMO";

	// Variables estáticas
	private static Formato formato = Formato.SIN_FORMATO;

	// Variables de instancia (siempre privadas)
	private Long id;
	private String nombre;
	private String apellidos;

	// Constructores
	public Persona(Long id, String nombre, String apellidos) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getApellidos());
	}

	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}

	public Persona(String nombre) {
		this(null, nombre, null);
	}

	public Persona() { // Implícito si no hay otro constructor
		this(null, NOMBRE_POR_DEFECTO, null);
	}


	// Métodos de acceso (getters y setters)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new PojosException("No se admiten ids negativos");
		}

		this.id = id;
	}

	public String getNombre() {
		return formatear(nombre);
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se admiten nombres nulos");
		}

		if (nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}

		this.nombre = nombre.trim();
	}

	public String getApellidos() {
		return formatear(apellidos);
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	// Getters y setters estáticos
	public static Formato getFormato() {
		return formato;
	}

	public static void setFormato(Formato formato) {
		Persona.formato = formato;
	}

	// Métodos de instancia
	public String getNombreCompleto() {
		return getNombre() + " " + getApellidos();
	}

	public String getInformacion() {
		return getId() + ": " + getNombre() + ", " + getApellidos();
	}

	// Métodos privados
	private static String formatear(String dato) {
		if (dato == null)
			return null;

		switch (formato) {
		case SIN_FORMATO:
			return dato;
		case MINUSCULAS:
			return dato.toLowerCase();
		case MAYUSCULAS:
			return dato.toUpperCase();
		default:
			return dato;
		}
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}
