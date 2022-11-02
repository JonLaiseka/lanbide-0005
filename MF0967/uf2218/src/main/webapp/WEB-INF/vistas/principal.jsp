<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h1>
		Bienvenido
		<%=session.getAttribute("usuario")%>
		${usuario}
	</h1>

	<c:choose>
		<c:when test="${not empty productos}">
			<ul>
				<c:forEach items="${productos}" var="p">
					<li>${p.id}:${p.nombre}</li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<h2>No se han encontrado productos</h2>
		</c:otherwise>
	</c:choose>

	<%
	Iterable<Producto> productos = (Iterable<Producto>) request.getAttribute("productos");
	if (productos.iterator().hasNext()) {
	%>
	<ul>
		<%
		for (Producto p : productos) {
		%>
		<li><%=p.getId()%>: <%=p.getNombre()%></li>
		<%
		}
		%>
	</ul>
	<%
	} else {
	%>
	<h2>No se han encontrado productos</h2>
	<%
	}
	%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>