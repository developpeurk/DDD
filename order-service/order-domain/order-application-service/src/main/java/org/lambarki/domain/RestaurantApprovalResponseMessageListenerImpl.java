package org.lambarki.domain;

import lombok.extern.slf4j.Slf4j;
import org.lambarki.domain.valueobject.RestaurantApprovalResponse;
import org.lambarki.ports.input.message.listener.resaurantapproval.RestaurantApprovalMessageListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalMessageListener {
    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
