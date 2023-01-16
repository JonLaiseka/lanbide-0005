package com.ipartek.formacion.spring.mf0966spring.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ipartek.formacion.spring.mf0966spring.entidades.Usuario;
import com.ipartek.formacion.spring.mf0966spring.servicios.UsuarioService;

public class GlobalController {

	@Autowired UsuarioService usuarioService;
	
	@ModelAttribute("usuario")
	public Usuario getUsuario(Principal principal) {
		if (principal == null) {
			return null;
		}
	
		String email = principal.getName();
	
		return usuarioService.buscarPorEmail(email);
	}

}