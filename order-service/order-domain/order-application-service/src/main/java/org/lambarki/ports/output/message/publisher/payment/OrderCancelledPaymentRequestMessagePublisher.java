package org.lambarki.ports.output.message.publisher.payment;

import org.lambarki.domain.event.OrderCancelledEvent;
import org.lambarki.domain.event.publisher.DomainEventPublisher;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
