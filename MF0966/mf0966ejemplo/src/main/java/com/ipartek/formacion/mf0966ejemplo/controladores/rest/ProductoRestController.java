package com.ipartek.formacion.mf0966ejemplo.controladores.rest;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;
import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/empleados/*")
public class ProductoRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		Long id = obtenerId(request);
		
		if(id == null) {
			out.write(gson.toJson(Globales.DAO_EMPLEADO.obtenerTodos()));
		} else {
			Empleado empleado = Globales.DAO_EMPLEADO.obtenerPorId(id);
			
			if(empleado == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			out.write(gson.toJson(empleado));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Empleado empleado = gson.fromJson(request.getReader(), Empleado.class);
				
		out.write(gson.toJson(Globales.DAO_EMPLEADO.insertar(empleado)));
		
		response.setStatus(HttpServletResponse.SC_CREATED);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Long id = obtenerId(request);
		
		if(id == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Empleado empleado = gson.fromJson(request.getReader(), Empleado.class);
		
		out.write(gson.toJson(Globales.DAO_EMPLEADO.modificar(empleado)));
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);
		
		Globales.DAO_EMPLEADO.borrar(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	private Long obtenerId(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null) {
			return null;
		}
		
		return Long.parseLong(pathInfo.substring(1));
	}
}
