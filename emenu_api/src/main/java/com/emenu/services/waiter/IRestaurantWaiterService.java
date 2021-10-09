package com.emenu.services.waiter;

import com.emenu.model.waiter.RestaurantWaiter;

/**
 * This is contract interface for all waiter services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantWaiterService {

    /**
     * Create new waiter.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param restaurantWaiter
     *        RestaurantWaiter
     * @throws Exception
     */
    void createNewWaiter(RestaurantWaiter restaurantWaiter) throws Exception;

    /**
     * Get waiter by id.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param id
     *        Long
     * @param locale
     *        String
     * @throws Exception
     */
    RestaurantWaiter getWaiterById(Long id, String locale);

    /**
     * Get waiter by user name.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param restaurantWaiter
     *        RestaurantWaiter
     * @throws Exception
     */
    RestaurantWaiter getWaiterByUserName(String userName, String locale);

}
