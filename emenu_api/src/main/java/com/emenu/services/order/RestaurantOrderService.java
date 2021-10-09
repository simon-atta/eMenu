package com.emenu.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emenu.model.order.RestaurantOrder;
import com.emenu.model.order.RestaurantOrderStatus;
import com.emenu.repo.order.RestaurantOrderRepository;

/**
 * Restaurant order service which contains all business logic for restaurant
 * order.
 *
 * @author Simon Ghobreil.
 */
@Service
public class RestaurantOrderService implements IRestaurantOrderService {

    @Autowired
    private RestaurantOrderRepository orderRepository;

    @Override
    public RestaurantOrder getOrderByTableId(Long tableId) throws Exception {
        return orderRepository.getActiveOrderByTable(tableId, RestaurantOrderStatus.DONE);
    }

}
