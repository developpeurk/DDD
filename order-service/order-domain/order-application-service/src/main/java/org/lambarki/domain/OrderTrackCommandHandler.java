package org.lambarki.domain;

import lombok.extern.slf4j.Slf4j;
import org.lambarki.domain.dto.track.TrackOrderQuery;
import org.lambarki.domain.dto.track.TrackOrderResponse;
import org.lambarki.domain.entity.Order;
import org.lambarki.domain.exception.OrderNotFoundException;
import org.lambarki.domain.mapper.OrderDataMapper;
import org.lambarki.domain.valueobject.TrackingId;
import org.lambarki.ports.output.repository.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse createOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> orderResult = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));
        if(orderResult.isEmpty()) {
            log.warn("Could not find order with tracking id: {} ", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order with tracking id: " + trackOrderQuery.getOrderTrackingId());
        }
        return orderDataMapper.orderToTrackOrderResponse(orderResult.get());
    }
}
