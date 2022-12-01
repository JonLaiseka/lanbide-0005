<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="decorada table table-striped table-hover table-bordered">
	<caption>Productos</caption>
	<thead class="table-dark">
		<tr>
			<th scope="col" class="text-end">Id</th>
			<th scope="col">Imagen</th>
			<th scope="col">Nombre</th>
			<th scope="col" class="text-end">Precio</th>
			<th scope="col">Categoría</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th scope="row" class="text-end">${p.id}</th>
				<td><img src="imgs/${p.id}.jpg" alt="${p.nombre}"></td>
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
			<td></td>
			<td><a class="btn btn-primary btn-sm" href="admin/producto">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>