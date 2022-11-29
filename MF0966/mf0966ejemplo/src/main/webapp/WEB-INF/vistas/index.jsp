<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Productos</h2>

<div
	class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	<c:forEach items="${productos}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="imgs/${p.id}.jpg" class="card-img-top"
					alt="Imagen de ${p.nombre}">
				<div class="card-body">
					<h3 class="card-title">${p.nombre}</h3>
					<p class="card-text lead">${p.categoria.nombre}</p>
					<p class="card-text">${p.descripcion}</p>
				</div>
				<div class="card-footer">
					<p class="text-center lead"><fmt:formatNumber value="${p.precio}"
							type="currency" /></p>
					<form action="carrito" method="post">
						<input type="hidden" name="id" value="${p.id}">
						<div class="input-group mb-3 w-100">
							<button class="btn btn-outline-danger menos" type="button"
								id="menos-${p.id}">-</button>
							<input type="text" class="form-control text-center border-top border-bottom border-dark lead"
								name="cantidad" value="${carrito.lineasPorId[p.id] != null ? carrito.lineasPorId[p.id].cantidad : 0}">
							<button class="btn btn-outline-success mas" type="button"
								id="mas-${p.id}">+</button>
						</div>
						<button class="btn btn-primary ms-auto w-100">Carrito</button>
					</form>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>