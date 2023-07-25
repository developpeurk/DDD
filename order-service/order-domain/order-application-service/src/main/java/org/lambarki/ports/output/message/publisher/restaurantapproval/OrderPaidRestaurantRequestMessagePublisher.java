package org.lambarki.ports.output.message.publisher.restaurantapproval;

import org.lambarki.domain.event.OrderPaidEvent;
import org.lambarki.domain.event.publisher.DomainEventPublisher;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
