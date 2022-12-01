package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito-total")
public class CarritoTotalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pedido pedido = (Pedido) request.getSession().getAttribute("carrito");
		
		String datos = request.getParameter("datos");
		
		String[] pares = datos.split(";");
		
		String[] partes;
		
		Long id;
		
		Integer cantidad;
		
		Producto producto;
		
		for(String par: pares) {
			partes = par.split(",");
			
			id = Long.parseLong(partes[0]);
			cantidad = Integer.parseInt(partes[1]);
			
			producto = Globales.DAO_PRODUCTO.obtenerPorId(id);
			
			pedido.guardar(cantidad, producto);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
