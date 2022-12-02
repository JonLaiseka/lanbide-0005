package com.ipartek.formacion.mf0966ejemplo.controladores;

import java.io.IOException;
import java.util.logging.Level;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
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

		CreatePayment postBody = gson.fromJson(request.getReader(), CreatePayment.class);

		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
				.setAmount(calculateOrderAmount(postBody.getItems())).setCurrency("eur").setAutomaticPaymentMethods(
						PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build())
				.build();

		// Create a PaymentIntent with the order amount and currency
		try {
			PaymentIntent paymentIntent = PaymentIntent.create(params);
			CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
			log.log(Level.INFO, "TODO OK");

			response.getWriter().write(gson.toJson(paymentResponse));
		} catch (StripeException e) {
			log.log(Level.SEVERE, "Ha fallado STRIPE", e);
		}

	}

	private static Gson gson = new Gson();

	static class CreatePayment {
		@SerializedName("items")
		Object[] items;

		public Object[] getItems() {
			return items;
		}
	}

	static class CreatePaymentResponse {
		@SuppressWarnings("unused")
		private String clientSecret;

		public CreatePaymentResponse(String clientSecret) {
			this.clientSecret = clientSecret;
		}
	}

	static Long calculateOrderAmount(Object[] items) {
		// Replace this constant with a calculation of the order's amount
		// Calculate the order total on the server to prevent
		// people from directly manipulating the amount on the client
		return 1400L;
	}

}
