package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Pedido pedido = (Pedido) request.getSession().getAttribute("carrito");

			Producto producto = Globales.DAO_PRODUCTO.obtenerPorId(Long.parseLong(id));

			pedido.guardar(producto);

			log.info(() -> "Se ha recibido el id " + id);
			log.info(producto::toString);

		} else {
			log.warning("No se ha recibido id en el Post");
		}

		response.sendRedirect(request.getContextPath() + "/carrito");
	}

}
