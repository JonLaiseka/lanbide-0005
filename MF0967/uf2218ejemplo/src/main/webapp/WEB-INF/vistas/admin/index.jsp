<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

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
		<tr>
			<th>1</th>
			<td>Ordenador</td>
			<td>123,12€</td>
			<td>
				<a class="btn btn-sm btn-primary" href="#">Editar</a>
				<a class="btn btn-sm btn-danger" href="#">Borrar</a>
			</td>
		</tr>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a class="btn btn-sm btn-primary" href="#">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>