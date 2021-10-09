package com.emenu.services.menu;

import java.util.List;

import com.emenu.model.menu.RestaurantMenuItem;

/**
 * This is contract interface for all menu items services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantMenuItemService {

    /**
     * Create new menu items.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param restaurantMenuItem
     *        RestaurantMenuItem
     * @throws Exception
     */
    void createMenuItem(RestaurantMenuItem restaurantMenuItem) throws Exception;

    /**
     * Get items belongs to specific category.
     *
     * @param locale
     *        Locale
     * @param catId
     *        Long
     * @return list of restaurant menu item.
     * @throws Exception
     */
    List<RestaurantMenuItem> getCategoryItemList(Long catId, String locale) throws Exception;

    /**
     * Get items belongs to specific category.
     *
     * @param locale
     *        Locale
     * @param catId
     *        Long
     * @param itemId
     *        Long
     * @return restaurant menu item.
     * @throws Exception
     */
    RestaurantMenuItem getMenuItemDetails(Long catId, Long itemId, String locale) throws Exception;

    /**
     * Assign item to category.
     *
     * @param catId
     *        Long
     * @param itemId
     *        Long
     * @throws Exception
     */
    void assignItemToCategoryMenu(Long itemId, Long catId) throws Exception;

}
