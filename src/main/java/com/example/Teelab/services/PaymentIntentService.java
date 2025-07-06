package com.example.Teelab.services;

import com.example.Teelab.auth.entities.User;
import com.example.Teelab.entities.Order;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentIntentService {

    public Map<String, String> createPaymentIntent(Order order) throws StripeException {
        User user = order.getUser();
        Map<String, String> metaData = new HashMap<>();
        metaData.put("orderId", order.getId().toString());

        PaymentIntentCreateParams paymentIntentCreateParams = PaymentIntentCreateParams.builder()
                .setAmount((long) (order.getTotalAmount() * 100)) // Convert amount to cents for USD
                .setCurrency("usd") // Set currency to USD
                .putAllMetadata(metaData)
                .setDescription("Test Payment Project -1")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                )
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentCreateParams);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("client_secret", paymentIntent.getClientSecret());
        return responseMap;
    }
}
