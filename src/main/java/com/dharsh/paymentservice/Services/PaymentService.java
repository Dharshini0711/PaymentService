package com.dharsh.paymentservice.Services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {
    public String generatePaymentLink(Long orderId) throws RazorpayException , StripeException;
}
