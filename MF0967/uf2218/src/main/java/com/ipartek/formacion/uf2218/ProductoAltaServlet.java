package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/alta")
public class ProductoAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String cantidad = request.getParameter("cantidad");
		String caducidad = request.getParameter("caducidad");
		
		Producto producto = new Producto();
		
		producto.setNombre(nombre);
		producto.setPrecio(new BigDecimal(precio));
		producto.setCantidad(Integer.parseInt(cantidad));
		producto.setCaducidad(LocalDate.parse(caducidad));
		
		Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
		
		dao.insertar(producto);
		
		response.sendRedirect("listado");
	}
}
