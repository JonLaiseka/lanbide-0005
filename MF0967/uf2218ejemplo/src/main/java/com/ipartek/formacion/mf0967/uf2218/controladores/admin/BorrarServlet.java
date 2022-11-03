package com.ipartek.formacion.mf0967.uf2218.controladores.admin;

import static com.ipartek.formacion.mf0967.uf2218.controladores.Globales.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		dao.borrar(Long.parseLong(id));
		
		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

}
