package org.lambarki;

import lombok.extern.slf4j.Slf4j;
import org.lambarki.domain.dto.message.PaymentResponse;
import org.lambarki.ports.input.message.listener.payment.PaymentResponseMessageListenner;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListenner {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {

    }
}
