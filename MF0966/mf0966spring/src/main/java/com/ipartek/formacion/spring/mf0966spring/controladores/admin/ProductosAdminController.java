package com.ipartek.formacion.spring.mf0966spring.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;
import com.ipartek.formacion.spring.mf0966spring.servicios.CategoriaService;
import com.ipartek.formacion.spring.mf0966spring.servicios.ProductoService;

@Controller
@RequestMapping("/admin")
public class ProductosAdminController {
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/productos")
	public String mostrarListado(Model modelo) {
		Iterable<Producto> productos = productoService.obtenerTodos();
		
		modelo.addAttribute("productos", productos);
		
		return "admin/productos";
	}
	
	@GetMapping({"/producto", "/producto/{id}"})
	public String mostrarFormularioProducto(@PathVariable(required = false) Long id, Model modelo) {
		if(id != null) {
			modelo.addAttribute("producto", productoService.obtenerPorId(id));
		}
		
		modelo.addAttribute("categorias", categoriaService.obtenerTodas());
		
		return "admin/producto";
	}
	
	@GetMapping("/producto/{id}/borrar")
	public String borrarProducto(@PathVariable Long id) {
		productoService.borrar(id);
		return "redirect:/admin/productos";
	}
	
}
