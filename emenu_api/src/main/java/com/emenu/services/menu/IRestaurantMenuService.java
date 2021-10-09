package com.emenu.services.menu;

import com.emenu.model.menu.RestaurantMenu;

/**
 * This is contract interface for all menu services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantMenuService {

    /**
     * Create new menu.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param restaurantMenu
     *        RestaurantMenu
     * @throws Exception
     */
    void createNewSection(RestaurantMenu restaurantMenu) throws Exception;

    /**
     * Get menu details locale.
     *
     * @param locale
     *        Locale
     * @return restaurant menu.
     * @throws Exception
     */
    RestaurantMenu getMenuByLocale(String locale) throws Exception;

}
