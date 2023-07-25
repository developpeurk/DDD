package org.lambarki.domain;

import org.lambarki.domain.entity.Order;
import org.lambarki.domain.entity.Restaurant;
import org.lambarki.domain.event.OrderCancelledEvent;
import org.lambarki.domain.event.OrderCreatedEvent;
import org.lambarki.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
