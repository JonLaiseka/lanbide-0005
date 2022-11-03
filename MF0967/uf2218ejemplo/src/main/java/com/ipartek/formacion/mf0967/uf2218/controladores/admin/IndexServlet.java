package com.ipartek.formacion.mf0967.uf2218.controladores.admin;

import static com.ipartek.formacion.mf0967.uf2218.controladores.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/admin/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Producto> productos = dao.obtenerTodos();
		
		request.setAttribute("productos", productos);		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}

}
