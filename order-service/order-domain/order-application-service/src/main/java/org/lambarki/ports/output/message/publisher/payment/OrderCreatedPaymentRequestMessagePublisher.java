package org.lambarki.ports.output.message.publisher.payment;

import org.lambarki.domain.event.OrderCreatedEvent;
import org.lambarki.domain.event.publisher.DomainEventPublisher;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
