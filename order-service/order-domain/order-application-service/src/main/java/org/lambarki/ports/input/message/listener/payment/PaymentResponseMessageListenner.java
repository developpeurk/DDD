package org.lambarki.ports.input.message.listener.payment;

import org.lambarki.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListenner {

    void paymentCompleted(PaymentResponse paymentResponse);
    void paymentCancelled(PaymentResponse paymentResponse);
}
