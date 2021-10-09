package com.emenu.repo.menu;

import org.springframework.data.repository.CrudRepository;

import com.emenu.model.menu.RestaurantMenu;

/**
 * Restaurant menu repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantMenuRepository extends CrudRepository<RestaurantMenu, Long> {

    RestaurantMenu findByLocale(String locale);

}
