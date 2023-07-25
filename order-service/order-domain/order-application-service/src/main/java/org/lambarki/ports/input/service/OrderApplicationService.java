package org.lambarki.ports.input.service;

import org.lambarki.domain.dto.create.CreateOrderCommand;
import org.lambarki.domain.dto.create.CreateOrderResponse;
import org.lambarki.domain.dto.track.TrackOrderQuery;
import org.lambarki.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
   CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
   TrackOrderResponse truckOder(@Valid TrackOrderQuery trackOrderQuery);
}
