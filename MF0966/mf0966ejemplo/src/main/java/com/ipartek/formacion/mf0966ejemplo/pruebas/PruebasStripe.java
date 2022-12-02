package com.ipartek.formacion.mf0966ejemplo.pruebas;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.model.Price;

public class PruebasStripe {
    public static void main(String[] args) throws StripeException {
        Stripe.apiKey = "sk_test_51HJjTvKQqwGUxNnflxdd6kKmoXHYKvcaUnG21goIhloN9DjCI4PYX7u0yKbpRRSdlIORDJmAe4da7ZUQ0O0Ghial00lrosK8h1";


        ProductCreateParams productParams =
            ProductCreateParams.builder()
                .setName("Starter Subscription")
                .setDescription("$12/Month subscription")
                .build();
        Product product = Product.create(productParams);
        System.out.println("Success! Here is your starter subscription product id: " + product.getId());

        PriceCreateParams params =
            PriceCreateParams
                .builder()
                .setProduct(product.getId())
                .setCurrency("usd")
                .setUnitAmount(1200L)
                .setRecurring(
                    PriceCreateParams.Recurring
                        .builder()
                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                        .build())
                .build();
        Price price = Price.create(params);
        System.out.println("Success! Here is your starter subscription price id: " + price.getId());
    }
}