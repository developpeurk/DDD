package org.lambarki.domain;

import lombok.extern.slf4j.Slf4j;
import org.lambarki.domain.dto.create.CreateOrderCommand;
import org.lambarki.domain.dto.create.CreateOrderResponse;
import org.lambarki.domain.dto.track.TrackOrderQuery;
import org.lambarki.domain.dto.track.TrackOrderResponse;
import org.lambarki.ports.input.service.OrderApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
 class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse truckOder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.createOrder(trackOrderQuery);
    }
}
