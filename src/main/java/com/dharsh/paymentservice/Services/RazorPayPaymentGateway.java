package com.dharsh.paymentservice.Services;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentGateway")
public class RazorPayPaymentGateway implements  PaymentService{
    private RazorpayClient razorpayClient;

    public RazorPayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        //paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()+ 10*60*1000);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for " + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name","Dharshini");
        customer.put("contact","+91 9521279429");
        customer.put("email","dharsh@example.com");

        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        paymentLinkRequest.put("reminder_enable",true);

        //JSONObject notes = new JSONObject();
        //notes.put("policy_name","Jeevan Bima");
        //paymentLinkRequest.put("notes",notes);

        paymentLinkRequest.put("callback_url","https://google.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
