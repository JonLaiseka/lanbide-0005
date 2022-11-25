<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Productos</h2>

<div
	class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	<c:forEach items="${productos}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="imgs/${p.id}.jpg" class="card-img-top" alt="Imagen de ${p.nombre}">
				<div class="card-body">
					<h3 class="card-title">${p.nombre}</h3>
					<p class="card-text">
						${p.categoria.nombre}
					</p>
					<p class="card-text">${p.descripcion}</p>
				</div>
				<div class="card-footer d-flex">
					<span class="btn"><fmt:formatNumber value="${p.precio}" type="currency"/></span>
					<a class="btn btn-primary ms-auto stretched-link" href="carrito?id=${p.id}">Carrito</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>