package com.ipartek.formacion.mf0967.uf2218.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
		Iterable<Producto> productos = dao.obtenerTodos();
		
		request.setAttribute("productos", productos);		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

}
