package com.emenu.repo.menu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emenu.model.menu.RestaurantMenuCategory;

/**
 * Restaurant menu category repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantMenuCategoryRepository extends CrudRepository<RestaurantMenuCategory, Long> {

    List<RestaurantMenuCategory> findByLocale(String locale);

}
