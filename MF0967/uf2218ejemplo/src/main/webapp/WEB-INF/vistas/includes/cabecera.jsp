<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es-ES" />

<!DOCTYPE html>
<html class="h-100">
<head>

<base href="${pageContext.request.contextPath}/" />

<meta charset="UTF-8">
<title>UF2218 Ejemplo</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">

<script src="js/jquery-3.5.1.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/dataTables.bootstrap5.min.js"></script>

<script>
	$(document).ready(function() {
		$('table').DataTable();
	});
</script>

</head>
<body class="d-flex flex-column h-100">
	<nav
		class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">UF2218 Ejemplo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="admin/index">Administración</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${alertaMensaje != null}">
		<div class="alert alert-${alertaNivel} alert-dismissible fade show"
			role="alert">
			${alertaMensaje}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<div class="container-fluid mt-4">