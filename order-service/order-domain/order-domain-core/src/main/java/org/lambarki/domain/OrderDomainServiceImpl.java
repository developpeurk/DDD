package org.lambarki.domain;

import lombok.extern.slf4j.Slf4j;
import org.lambarki.domain.entity.Order;
import org.lambarki.domain.entity.OrderItem;
import org.lambarki.domain.entity.Product;
import org.lambarki.domain.entity.Restaurant;
import org.lambarki.domain.event.OrderCancelledEvent;
import org.lambarki.domain.event.OrderCreatedEvent;
import org.lambarki.domain.event.OrderPaidEvent;
import org.lambarki.domain.exception.OrderDomainException;
import org.lambarki.domain.valueobject.ProductId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{

    private static final String UTC = "UTC";
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
       validateRestaurant(restaurant);
       setOrderProductInformation(order, restaurant);
       order.initializeOrder();
       log.info("Order with id: {} is initiatied", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }



    @Override
    public OrderPaidEvent payOrder(Order order) {
       order.pay();
       log.info("Order with id: {} is paid", order.getId().getValue());

        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id: {} is approved", order.getId().getValue());

    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id:{}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());

    }

    private void validateRestaurant(Restaurant restaurant) {
        if(!restaurant.isActive()) {
            throw new OrderDomainException("Restaurant with id " + restaurant.getId().getValue() +
                    " is currently not active!");
        }
    }



//    private void setOrderProductInformation(Order order, Restaurant restaurant) {
//        order.getItems().forEach(orderItem -> {
//            restaurant.getProducts().forEach(restaurantProduct -> {
//                Product currentProduct = orderItem.getProduct();
//                if(currentProduct.equals(restaurantProduct)) {
//                    currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(), restaurantProduct.getPrice())
//                }
//            });
//        });
//    }

    //to reduce the time complexity

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        // Step 1: Create a HashMap to store the restaurant's products with their identifiers.
        Map<ProductId, Product> restaurantProductsMap = new HashMap<>();
        for (Product restaurantProduct : restaurant.getProducts()) {
            restaurantProductsMap.put(restaurantProduct.getId(), restaurantProduct);
        }


        for (OrderItem orderItem : order.getItems()) {
            Product currentProduct = orderItem.getProduct();
            Product matchingRestaurantProduct = restaurantProductsMap.get(currentProduct.getId());
            if (matchingRestaurantProduct != null) {
                // Product found in the restaurant, update the product information.
                currentProduct.updateWithConfirmedNameAndPrice(matchingRestaurantProduct.getName(), matchingRestaurantProduct.getPrice());
            }
        }
    }

}
