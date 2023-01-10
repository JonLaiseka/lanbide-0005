package com.ipartek.formacion.spring.mf0966spring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;
import com.ipartek.formacion.spring.mf0966spring.entidades.Rol;
import com.ipartek.formacion.spring.mf0966spring.entidades.Usuario;
import com.ipartek.formacion.spring.mf0966spring.repositorios.ClienteRepository;
import com.ipartek.formacion.spring.mf0966spring.repositorios.RolRepository;
import com.ipartek.formacion.spring.mf0966spring.repositorios.UsuarioRepository;

import lombok.extern.java.Log;

@Log
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private RolRepository repoRol;

	@Autowired
	private ClienteRepository repoCliente;

	@Override
	public Usuario buscarPorEmail(String email) {
		return repoUsuario.findByEmail(email);
	}

	@Override
	public Usuario altaDatosCliente(Long idUsuario, Cliente cliente) {
		log.info(idUsuario.toString());

		log.info(cliente.toString());

		Usuario usuario = repoUsuario.findById(idUsuario).orElse(null);

		if (usuario == null) {
			throw new ServiciosException("No se ha encontrado el usuario");
		}
		
		log.info(usuario.toString());

		repoCliente.save(cliente);
		usuario.setCliente(cliente);
		repoUsuario.save(usuario);

		return usuario;
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		Rol rol = repoRol.findByNombre("USER");
		
		if(rol == null) {
			throw new ServiciosException("No se ha encontrado el rol de usuario");
		}

		usuario.setRol(rol);
		
		log.info("Se acaba de registrar el usuario " + usuario);
		
		return repoUsuario.save(usuario);
	}

}
