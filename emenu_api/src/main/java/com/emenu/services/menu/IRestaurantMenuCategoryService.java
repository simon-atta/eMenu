package com.emenu.services.menu;

import java.util.List;

import com.emenu.model.menu.RestaurantMenuCategory;
import com.emenu.model.menu.dto.CategoryResponse;

/**
 * This is contract interface for all menu category services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantMenuCategoryService {

    /**
     * Create new menu category.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param restaurantMenuCategory
     *        RestaurantMenuCategory
     * @throws Exception
     */
    void createMenuCategory(RestaurantMenuCategory restaurantMenuCategory) throws Exception;

    /**
     * Get menu details locale.
     *
     * @param locale
     *        Locale
     * @param menuId
     *        Long
     * @return restaurant menu category.
     * @throws Exception
     */
    List<CategoryResponse> getCategoriesList(String locale) throws Exception;

    /**
     * Assign category to menu.
     *
     * @param catId
     *        Long
     * @param menuId
     *        Long
     * @throws Exception
     */
    void assignCategoryToMenu(Long menuId, Long catId) throws Exception;

}
