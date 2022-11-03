<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.nombre}</td>
				<td>
					<fmt:formatNumber type="currency" value="${p.precio}"></fmt:formatNumber>
				</td>
				<td><a class="btn btn-sm btn-primary" href="#">Editar</a> <a
					class="btn btn-sm btn-danger" href="#">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-sm btn-primary" href="#">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>