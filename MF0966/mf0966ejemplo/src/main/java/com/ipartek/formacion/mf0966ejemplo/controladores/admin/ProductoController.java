package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null && id.trim().length() != 0) {
			Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));
			request.setAttribute("producto", producto);
		}

		Iterable<Categoria> categorias = Globales.DAO_CATEGORIA.obtenerTodos();

		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recopilar datos de petición
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		String categoria = request.getParameter("categoria");
		
		// Empaquetar datos en modelo
		Producto producto = new Producto(id, nombre, precio, descripcion, categoria);
		
		// Lógica de negocio
		if(producto.getId() != null) {
			Globales.DAO_PRODUCTO.modificar(producto);
		} else {
			Globales.DAO_PRODUCTO.insertar(producto);
		}
		
		// Preparar el modelo para la siguiente pantalla
		// Ir a la siguiente pantalla
		response.sendRedirect("productos");
	}

}
