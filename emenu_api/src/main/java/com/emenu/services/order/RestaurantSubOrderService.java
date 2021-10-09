package com.emenu.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emenu.model.order.RestaurantOrder;
import com.emenu.model.order.RestaurantOrderStatus;
import com.emenu.model.order.RestaurantSubOrder;
import com.emenu.repo.order.RestaurantOrderRepository;
import com.emenu.repo.order.RestaurantSubOrderRepository;

/**
 * Restaurant sub order service which contains all business logic for restaurant
 * sub order.
 *
 * @author Simon Ghobreil.
 */
@Service
public class RestaurantSubOrderService implements IRestaurantSubOrderService {

    @Autowired
    private RestaurantSubOrderRepository subOrderRepository;

    @Autowired
    private RestaurantOrderRepository orderRepository;

    @Override
    @Transactional
    public void submitSubOrder(RestaurantSubOrder subOrder, Long tableId) throws Exception {

        RestaurantOrder restaurantOrder = orderRepository.getActiveOrderByTable(tableId, RestaurantOrderStatus.CREATED);

        subOrder.setOrder(restaurantOrder);

        subOrderRepository.save(subOrder);
    }

}
