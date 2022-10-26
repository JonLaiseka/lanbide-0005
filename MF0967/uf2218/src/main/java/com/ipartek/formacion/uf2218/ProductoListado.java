package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/listado")
public class ProductoListado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
		
		Iterable<Producto> productos = dao.obtenerTodos();
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		for(Producto producto: productos) {
			out.printf("%3s\t%20s\t%10s\t%3s\t%10s\n", producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCantidad(), producto.getCaducidad());
		}
	}
}
