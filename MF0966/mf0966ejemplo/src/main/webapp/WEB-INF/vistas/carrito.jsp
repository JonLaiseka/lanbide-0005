<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<caption>Carrito</caption>
	<thead class="table-dark">
		<tr>
			<th scope="col">Imagen</th>
			<th scope="col">Nombre</th>
			<th scope="col" class="text-end">Precio</th>
			<th scope="col" class="text-end">Cantidad</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito.lineas}" var="l">
			<tr>
				<td><img src="imgs/${l.producto.id}.jpg" alt="${p.nombre}"></td>
				<td>${l.producto.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${l.producto.precio}"/></td>
				<td class="text-end">${l.cantidad}</td>
				<td>
					<%--
				<a class="btn btn-primary btn-sm"
					href="admin/producto?id=${p.id}">Editar</a> <a
					class="btn btn-danger btn-sm"
					href="admin/producto/borrar?id=${p.id}">Borrar</a>
					 --%>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
			<%-- <a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>  --%>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>