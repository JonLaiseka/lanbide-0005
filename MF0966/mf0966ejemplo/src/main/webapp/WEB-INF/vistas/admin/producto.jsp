<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form>
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id"
				value="${producto.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre"
				value="${p.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control" id="precio"
				name="precio" value="${producto.precio}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="categoria" class="col-sm-2 col-form-label">categoria</label>
		<div class="col-sm-10">
			<select class="form-select" id="categoria" name="categoria">
				<option selected value="0">Seleccione una categoría</option>
				<c:forEach items="${categorias}" var="c">
					<option ${producto.categoria.id == c.id ? 'selected' : '' }
						value="${c.id}">${c.nombre}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">descripcion</label>
		<div class="col-sm-10">
			<textarea class="form-control" id="descripcion" name="descripcion"></textarea>
		</div>
	</div>

	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>