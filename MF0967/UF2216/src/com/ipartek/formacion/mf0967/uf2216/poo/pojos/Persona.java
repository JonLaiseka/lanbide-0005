package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

public class Persona {
	// Variables de instancia (siempre privadas)
	private Long id;
	private String nombre;
	
	// Constructores
	public Persona(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public Persona() { // Implícito si no hay otro constructor
		this(null, "ANÓNIMO");
	}
	
	// Métodos de acceso (getters y setters)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten ids negativos");
		}
		
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se admiten nombres nulos");
		}
		
		if(nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre.trim();
	}
}
