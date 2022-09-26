package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

public class Cliente extends Persona {
	private String nif;

	public Cliente(Long id, String nombre, String apellidos, String nif) {
		super(id, nombre, apellidos);
		setNif(nif);
	}
	
	public Cliente(String nombre, String apellidos, String nif) {
		this(null, nombre, apellidos, nif);
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	// Redefinir métodos ("Override")
	@Override
	public String getInformacion() {
		return super.getInformacion() + ", " + getNif();
	}
	
}
