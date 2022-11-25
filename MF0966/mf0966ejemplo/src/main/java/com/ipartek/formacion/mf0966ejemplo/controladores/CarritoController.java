package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Pedido pedido = (Pedido) request.getSession().getAttribute("carrito");

			pedido.guardar(Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id)));
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
