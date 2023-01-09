package com.ipartek.formacion.spring.mf0966spring.servicios;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;
import com.ipartek.formacion.spring.mf0966spring.entidades.Usuario;

public interface UsuarioService {
	Usuario buscarPorEmail(String email);
	
	Usuario altaDatosCliente(Long idUsuario, Cliente cliente);
}
