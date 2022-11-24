package com.ipartek.formacion.mf0966ejemplo.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto/borrar")
public class ProductosBorrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Globales.DAO_PRODUCTO.borrar(Long.parseLong(id));
		
		response.sendRedirect("../productos");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
