package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nif);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nif, other.nif);
	}
	
	
	
}
