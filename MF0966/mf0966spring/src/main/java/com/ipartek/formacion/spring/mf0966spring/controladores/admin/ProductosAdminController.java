package com.ipartek.formacion.spring.mf0966spring.controladores.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.spring.mf0966spring.controladores.GlobalController;
import com.ipartek.formacion.spring.mf0966spring.entidades.Producto;
import com.ipartek.formacion.spring.mf0966spring.servicios.CategoriaService;
import com.ipartek.formacion.spring.mf0966spring.servicios.ProductoService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class ProductosAdminController extends GlobalController {
	public static final String UPLOAD_DIRECTORY = getResourceAsFile("static/imgs").getAbsolutePath();
	
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

	public static File getResourceAsFile(String relativeFilePath) {
		try {
			return ResourceUtils.getFile(String.format("classpath:%s", relativeFilePath));
		} catch (FileNotFoundException e) {
			log.throwing(ProductosAdminController.class.getName(), "getResourceAsFile", e);
			return null;
		}
	}

	@GetMapping({ "/producto", "/producto/{id}" })
	public String mostrarFormularioProducto(@PathVariable(required = false) Long id, Model modelo, Producto producto) {
		if (id != null) {
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

	@PostMapping("/producto")
	public String guardarProducto(@Valid Producto producto, BindingResult bindingResult, Model modelo,
			@RequestParam("imagen") MultipartFile imagen, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			modelo.addAttribute("categorias", categoriaService.obtenerTodas());
			
			modelo.addAttribute("mensaje", "Corrige los errores en los campos");
			modelo.addAttribute("nivel", "danger");
				
			return "/admin/producto";
		}

		if (producto.getId() == null) {
			productoService.insertar(producto);
		} else {
			productoService.modificar(producto);
		}

		String nombre = imagen.getOriginalFilename();
		if (nombre != null && nombre.trim().length() != 0) {

			Path ruta = Paths.get(UPLOAD_DIRECTORY, producto.getId() + ".jpg");
			try {
				log.info(ruta.toString());
				Files.write(ruta, imagen.getBytes());
			} catch (IOException e) {
				log.throwing(ProductosAdminController.class.getName(), "guardarProducto", e);
				return "admin/producto";
			}
		}
		
		redirectAttributes.addFlashAttribute("mensaje", "Modificación del producto correcta");
		redirectAttributes.addFlashAttribute("nivel", "success");
		
		return "redirect:/admin/productos";
	}
}
