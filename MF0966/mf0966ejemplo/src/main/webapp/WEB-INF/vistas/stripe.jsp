<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div id="contenedor-stripe">
	<!-- Display a payment form -->
	<form id="payment-form">
		<div id="payment-element">
			<!--Stripe.js injects the Payment Element-->
		</div>
		<button id="submit">
			<div class="spinner hidden" id="spinner"></div>
			<span id="button-text">Pay now</span>
		</button>
		<div id="payment-message" class="hidden"></div>
	</form>
</div>

<script src="https://js.stripe.com/v3/"></script>
<script src="js/stripe.js" defer></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>