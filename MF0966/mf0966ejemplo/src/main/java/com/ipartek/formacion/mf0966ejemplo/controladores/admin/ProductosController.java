package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("productos", Globales.DAO_PRODUCTO.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/productos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
