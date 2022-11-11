<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/producto" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control ${producto.errores.id == null ? '': 'is-invalid' }" id="id" name="id" value="${producto.id}">
			<div class="invalid-feedback">
				${producto.errores.id}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control ${producto.errores.nombre == null ? '': 'is-invalid' }" id="nombre" name="nombre" value="${producto.nombre}">
			<div class="invalid-feedback">
				${producto.errores.nombre}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control ${producto.errores.precio == null ? '': 'is-invalid' }" id="precio" name="precio" value="${producto.precio}">
			<div class="invalid-feedback">
				${producto.errores.precio}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="cantidad" class="col-sm-2 col-form-label">Cantidad</label>
		<div class="col-sm-10">
			<input type="number" class="form-control ${producto.errores.cantidad == null ? '': 'is-invalid' }" id="cantidad" name="cantidad" value="${producto.cantidad}">
			<div class="invalid-feedback">
				${producto.errores.cantidad}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="caducidad" class="col-sm-2 col-form-label">Caducidad</label>
		<div class="col-sm-10">
			<input type="date" class="form-control ${producto.errores.caducidad == null ? '': 'is-invalid' }" id="caducidad" name="caducidad" value="${producto.caducidad}">
			<div class="invalid-feedback">
				${producto.errores.caducidad}
			</div>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>