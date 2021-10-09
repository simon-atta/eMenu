package com.emenu.services.order;

import com.emenu.model.order.RestaurantSubOrder;

/**
 * This is contract interface for all sub order services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantSubOrderService {

    /**
     * Submit sub order.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param subOrder
     *        RestaurantSubOrder
     * @param tableId
     *        Long
     * @throws Exception
     */
    void submitSubOrder(RestaurantSubOrder subOrder, Long tableId) throws Exception;

}
