package com.ipartek.formacion.mf0967.uf2218.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if(validarLogin(usuario, password)) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/admin/index");
		} else {
			request.setAttribute("alertaNivel", "danger");
			request.setAttribute("alertaMensaje", "Usuario o contraseña incorrectos");
			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
		
	}

	private boolean validarLogin(String usuario, String password) {
		return "javier".equals(usuario) && "lete".equals(password);
	}
}
