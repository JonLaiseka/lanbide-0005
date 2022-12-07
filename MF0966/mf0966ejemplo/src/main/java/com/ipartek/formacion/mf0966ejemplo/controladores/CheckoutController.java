package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Pedido pedido = (Pedido) session.getAttribute("carrito");

		Factura factura = new Factura(pedido);

		factura.setCodigo(null);
		factura.setCliente(usuario.getCliente());
		factura.setEmpleado(Globales.EMPLEADO);
		factura.setFecha(null);

		session.setAttribute("factura", factura);

		request.getRequestDispatcher("/WEB-INF/vistas/checkout.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
