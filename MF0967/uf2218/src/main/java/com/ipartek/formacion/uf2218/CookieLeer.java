package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookies/leer")
public class CookieLeer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			Map<String, Cookie> cookieMap = Arrays.stream(cookies)
					.collect(Collectors.toMap(Cookie::getName, cookie -> cookie));

			Cookie cookie = cookieMap.get(request.getParameter("cookie"));
			String colores = cookie.getValue();

//			Stream<Cookie> stream = Arrays.stream(cookies);
//			Stream<Cookie> streamFiltrado = stream.filter(cookie -> cookie.getName().equals("colores"));
//			Optional<Cookie> cookieOptional = streamFiltrado.findFirst();
//			// Cookie cookie = cookieOptional.orElse(null);
//
//			if (cookieOptional.isPresent()) {
			if (colores != null) {
				out.println(colores);

//				Cookie cookie = cookieOptional.get();
//
//				out.println(cookie.getValue());
			} else {
				out.println("No se ha encontrado");
			}
		} else {
			out.println("No se ha recibido ninguna cookie");
		}
	}
}
