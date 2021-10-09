package com.emenu.repo.menu;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emenu.model.menu.RestaurantMenuItem;

/**
 * Restaurant menu item repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantMenuItemRepository extends CrudRepository<RestaurantMenuItem, Long> {

    @Query("from RestaurantMenuItem item where item.category.id=?1 and item.locale = ?2")
    List<RestaurantMenuItem> getCategoryItems(Long catId, String locale);

    @Query("from RestaurantMenuItem item where item.category.id=?1 and item.id=?2 and item.locale = ?3")
    RestaurantMenuItem getMenuItemDetails(Long catId, Long itemId, String locale);

}
