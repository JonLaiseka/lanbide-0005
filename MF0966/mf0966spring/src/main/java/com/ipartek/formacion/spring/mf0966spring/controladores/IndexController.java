package com.ipartek.formacion.spring.mf0966spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido;
import com.ipartek.formacion.spring.mf0966spring.servicios.ProductoService;

@Controller
@RequestMapping("/")
@SessionAttributes("carrito")
public class IndexController {
	@ModelAttribute("carrito")
	public Pedido getCarrito() {
		return new Pedido();
	}
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", servicio.obtenerTodos());
		return "index";
	}
}
