package com.ipartek.formacion.spring.mf0968ejemplo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Usuario;
import com.ipartek.formacion.spring.mf0968ejemplo.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {
	private static final String ADMIN_USUARIO = "admin/usuario";
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping
	public String listado(Model modelo) {
		modelo.addAttribute("usuarios", servicio.obtenerTodos());
		return "admin/usuarios";
	}
	
	@GetMapping("insertar")
	public String formularioVacio(Usuario usuario, Model modelo) {
		modelo.addAttribute("roles", servicio.obtenerRoles());
		return ADMIN_USUARIO;
	}
	
	@GetMapping("{id}")
	public String formularioConDatos(@PathVariable Long id, Model modelo) {
		Usuario usuario = servicio.obtenerPorId(id);
		
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("roles", servicio.obtenerRoles());
		
		return ADMIN_USUARIO;
	}
	
	@PostMapping
	public String aceptar(@Valid Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return ADMIN_USUARIO;
		}
		
		System.out.println(usuario);
		
		if(usuario.getId() != null) {
			servicio.modificar(usuario);
		} else {
			servicio.insertar(usuario);
		}
		
		return "redirect:/admin/usuarios";
	}
	
	@GetMapping("borrar/{id}")
	public String borrar(@PathVariable Long id) {
		servicio.borrar(id);
		
		return "redirect:/admin/usuarios";
	}
}
