package com.ipartek.formacion.spring.mf0966spring.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ipartek.formacion.spring.mf0966spring.entidades.Cliente;
import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;
import com.ipartek.formacion.spring.mf0966spring.entidades.Usuario;
import com.ipartek.formacion.spring.mf0966spring.servicios.CarritoService;
import com.ipartek.formacion.spring.mf0966spring.servicios.ProductoService;
import com.ipartek.formacion.spring.mf0966spring.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
@SessionAttributes({"carrito", "usuario"})
public class IndexController {
	@ModelAttribute("carrito")
	public Pedido getCarrito() {
		return new Pedido();
	}
	
	@ModelAttribute("usuario") 
	public Usuario getUsuario(Principal principal) {
		if(principal == null) {
			return null;
		}
		
		String email = principal.getName();
		
		return usuarioService.buscarPorEmail(email);
	}
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CarritoService carritoService;

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", productoService.obtenerTodos());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/carrito")
	public String verCarrito() {
		return "carrito";
	}
	
	@PostMapping("/carrito")
	public String agregarProductoACarrito(Long id, Integer cantidad, @SessionAttribute Pedido carrito) {
		carritoService.guardarProductoEnCarrito(id, cantidad, carrito);

		return "redirect:/carrito";
	}

	@GetMapping("/confirmacion")
	public String confirmacion(@SessionAttribute Usuario usuario, Model modelo) {
		if(usuario == null || usuario.getCliente() == null) {
			return "redirect:/alta-cliente";
		}
		
		return "confirmacion";
	}
	
	@GetMapping("/alta-cliente")
	public String altaCliente(Cliente cliente) {		
		return "alta-cliente";
	}
	
	@PostMapping("/alta-cliente")
	public String altaClientePost(@SessionAttribute Usuario usuario, @Valid Cliente cliente, BindingResult bindingResult, Model modelo) {
		if(bindingResult.hasErrors()) {
			return "alta-cliente";
		}
		
		modelo.addAttribute("usuario", usuarioService.altaDatosCliente(usuario.getId(), cliente));
		
		return "redirect:/confirmacion";
	}
	
	@GetMapping("/cerrar-sesion")
	public String abandonarCarrito(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}
