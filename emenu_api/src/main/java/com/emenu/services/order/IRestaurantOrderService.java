package com.emenu.services.order;

import com.emenu.model.order.RestaurantOrder;

/**
 * This is contract interface for all restaurant order service.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantOrderService {

    /**
     * Get order by table id.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param tableId
     *        Long
     * @throws Exception
     */
    RestaurantOrder getOrderByTableId(Long tableId) throws Exception;

}
