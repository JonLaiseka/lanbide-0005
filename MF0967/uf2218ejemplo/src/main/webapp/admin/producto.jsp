<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form>
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id">
			<div class="invalid-feedback">
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre">
			<div class="invalid-feedback">
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control" id="precio" name="precio">
			<div class="invalid-feedback">
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="cantidad" class="col-sm-2 col-form-label">Cantidad</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="cantidad" name="cantidad">
			<div class="invalid-feedback">
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="caducidad" class="col-sm-2 col-form-label">Caducidad</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" id="caducidad" name="caducidad">
			<div class="invalid-feedback">
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