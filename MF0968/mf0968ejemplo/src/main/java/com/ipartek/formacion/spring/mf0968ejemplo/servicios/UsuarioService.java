package com.ipartek.formacion.spring.mf0968ejemplo.servicios;

import java.util.List;

import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Rol;
import com.ipartek.formacion.spring.mf0968ejemplo.entidades.Usuario;

public interface UsuarioService {
	List<Usuario> obtenerTodos();
	Usuario obtenerPorId(Long id);
	Usuario obtenerPorEmail(String email);
	
	Usuario insertar(Usuario usuario);
	Usuario modificar(Usuario usuario);
	void borrar(Long id);
	
	List<Rol> obtenerRoles();
}
