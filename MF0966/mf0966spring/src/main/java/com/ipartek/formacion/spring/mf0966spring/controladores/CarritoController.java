package com.ipartek.formacion.spring.mf0966spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;
import com.ipartek.formacion.spring.mf0966spring.servicios.CarritoService;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

	@ModelAttribute("carrito")
	public Pedido getCarrito() {
		return new Pedido();
	}

	@Autowired
	private CarritoService carritoService;

	@GetMapping
	public String verCarrito() {
		return "carrito";
	}
	
	@PostMapping
	public String agregarProductoACarrito(Long id, Integer cantidad, Model modelo) {
		Pedido pedido = (Pedido) modelo.getAttribute("carrito");
		
		carritoService.guardarProductoEnCarrito(id, cantidad, pedido);

		return "redirect:/carrito";
	}

	@GetMapping("/abandonar")
	public String abandonarCarrito(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}
