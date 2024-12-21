package com.dharsh.paymentservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkRequestDto {
    public Long orderId;
}
