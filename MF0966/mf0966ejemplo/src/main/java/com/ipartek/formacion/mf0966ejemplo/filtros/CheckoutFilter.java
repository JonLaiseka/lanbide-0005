package com.ipartek.formacion.mf0966ejemplo.filtros;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/checkout")
public class CheckoutFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			if (usuario.getCliente() != null) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/cliente");
			}
		} else {
			req.setAttribute("alertaMensaje", "Necesito que te loguees para poder hacer el checkout");
			req.setAttribute("alertaNivel", "danger");

			req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}
}
