<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Carrito</h2>

<div class="table-responsive">
	<table class="decorada table table-striped table-hover table-bordered">
		<caption class="d-none">Carrito</caption>
		<thead class="table-dark">
			<tr>
				<th scope="col">Imagen</th>
				<th scope="col">Nombre</th>
				<th scope="col" class="text-end">Precio</th>
				<th scope="col" class="text-end">Cantidad</th>
				<th scope="col" class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrito.lineas}" var="l">
				<tr>
					<td><img height="25" src="imgs/${l.producto.id}.jpg"
						alt="${l.producto.nombre}"></td>
					<td>${l.producto.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${l.producto.precio}" /></td>
					<td class="text-end">${l.cantidad}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${l.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td class="text-end"><fmt:formatNumber type="currency"
						value="${carrito.total}" /></td>
			</tr>
		</tfoot>
	</table>
</div>

<a class="btn btn-primary w-100 mb-3" href="">Volver al listado de productos</a>

<a class="btn btn-primary w-100" href="checkout">Pagar</a>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>