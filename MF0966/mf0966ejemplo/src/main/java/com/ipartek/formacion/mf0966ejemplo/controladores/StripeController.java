package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;

import com.google.gson.Gson;
import com.ipartek.formacion.mf0966ejemplo.modelos.Pedido;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
@WebServlet("/stripe")
public class StripeController extends HttpServlet {
	static {
		// This is your test secret API key.
		Stripe.apiKey = "sk_test_51HJjTvKQqwGUxNnflxdd6kKmoXHYKvcaUnG21goIhloN9DjCI4PYX7u0yKbpRRSdlIORDJmAe4da7ZUQ0O0Ghial00lrosK8h1";
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/stripe.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Entrada de doPost de STRIPE");
		response.setContentType("application/json");

		Pedido pedido = (Pedido) request.getSession().getAttribute("carrito");
		
		String secret = realizarPago(pedido);
		
		response.getWriter().write(gson.toJson(secret));
	}

	private static Gson gson = new Gson();
	
	private String realizarPago(Pedido pedido) {
		Long total = pedido.getTotal().multiply(new BigDecimal(100)).longValue();
		
		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
				.setAmount(total).setCurrency("eur").setAutomaticPaymentMethods(
						PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build())
				.build();

		// Create a PaymentIntent with the order amount and currency
		try {
			PaymentIntent paymentIntent = PaymentIntent.create(params);
			
			log.log(Level.INFO, paymentIntent.getClientSecret());
			log.log(Level.INFO, "TODO OK");
			
			return paymentIntent.getClientSecret();
		} catch (StripeException e) {
			log.log(Level.SEVERE, "Ha fallado STRIPE", e);
			
			throw new RuntimeException("Ha fallado STRIPE", e);
		}
	}
}
