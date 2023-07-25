package org.lambarki.ports.output.repository;

import org.lambarki.domain.entity.Order;
import org.lambarki.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
