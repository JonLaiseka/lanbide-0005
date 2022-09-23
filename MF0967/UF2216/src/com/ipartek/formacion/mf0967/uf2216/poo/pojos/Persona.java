package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

public class Persona {
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
	
	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}
	
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getApellidos());
	}
	
	public Persona() { // Implícito si no hay otro constructor
		this(null, "ANÓNIMO", null);
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	// Métodos de instancia
	public String getNombreCompleto() {
		return getNombre() + " " + getApellidos();
	}
	
	public String getInformacion() {
		return getId() + ": " + getNombre() + ", " + getApellidos();
	}
}
