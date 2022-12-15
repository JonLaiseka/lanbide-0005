<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<caption>Empleados</caption>
	<thead class="table-dark">
		<tr>
			<th scope="col" class="text-end">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">NIF</th>
			<th scope="col">Jefe</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-primary btn-sm" href="javascript:editar()">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<form>
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nif" class="col-sm-2 col-form-label">NIF</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nif">
		</div>
	</div>
	<div class="row mb-3">
		<label for="jefe" class="col-sm-2 col-form-label">Jefe</label>
		<div class="col-sm-10">
			<select class="form-select" id="jefe"></select>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<script src="js/empleados.js"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>