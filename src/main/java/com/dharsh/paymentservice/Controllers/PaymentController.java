package com.dharsh.paymentservice.Controllers;

import com.dharsh.paymentservice.Dtos.GeneratePaymentLinkRequestDto;
import com.dharsh.paymentservice.Services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(@Qualifier("StripePaymentGateway") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto paymentLinkRequestDto) throws RazorpayException, StripeException {
        return paymentService.generatePaymentLink(paymentLinkRequestDto.orderId);
    }
}
