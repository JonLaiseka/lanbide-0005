package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, email, password);
		
		Usuario usuarioValidado = validarUsuario(usuario);
		
		if(usuarioValidado != null) {
			request.getSession().setAttribute("usuario", usuarioValidado);
			
			if(usuarioValidado.getRol().getNombre().equals("ADMIN")) {
				response.sendRedirect(request.getContextPath() + "/admin/productos");
			} else {
				response.sendRedirect(request.getContextPath() + "/index");
			}
		} else {
			request.setAttribute("usuario", usuario);
			
			request.setAttribute("alertaMensaje", "No es válido el usuario");
			request.setAttribute("alertaNivel", "danger");
			
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		Usuario recibido = Globales.DAO_USUARIOS.obtenerPorEmail(usuario.getEmail());
		
		if(recibido != null && usuario.getPassword().equals(recibido.getPassword())) {
			return recibido;
		} else {
			return null;
		}
	}

}
