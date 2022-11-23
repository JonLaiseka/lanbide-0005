<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th>Categoría</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${p.precio}"/></td>
				<td>${p.categoria.nombre}</td>
				<td><a class="btn btn-primary btn-sm"
					href="admin/producto?id=${p.id}">Editar</a> <a
					class="btn btn-danger btn-sm"
					href="admin/producto/borrar?id=${p.id}">Borrar</a>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>