package com.ipartek.formacion.spring.mf0966spring.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	private Long id;
	private String email;
	private String password;
	
	private Rol rol;
	
	private Cliente cliente;

	public Usuario(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
