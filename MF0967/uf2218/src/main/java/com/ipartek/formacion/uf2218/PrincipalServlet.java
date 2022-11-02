package com.ipartek.formacion.uf2218;

import java.io.IOException;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("usuario");
		
		if(user == null) {
			//response.sendRedirect("login.jsp");
			request.setAttribute("error", "No se puede acceder a principal sin autenticarse");
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		} else {
			request.setAttribute("productos", dao.obtenerTodos());
			request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
		}
	}
}
