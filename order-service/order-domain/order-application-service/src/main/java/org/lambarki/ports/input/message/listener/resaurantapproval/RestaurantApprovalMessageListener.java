package org.lambarki.ports.input.message.listener.resaurantapproval;

import org.lambarki.domain.valueobject.RestaurantApprovalResponse;

public interface RestaurantApprovalMessageListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);
    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
