package com.emenu.services.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emenu.model.menu.RestaurantMenu;
import com.emenu.repo.menu.RestaurantMenuRepository;

/**
 * Restaurant menu service which contains all business logic for restaurant
 * menu.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "menus")
public class RestaurantMenuService implements IRestaurantMenuService {

    @Autowired
    private RestaurantMenuRepository restaurantMenuService;

    @Override
    @CacheEvict(allEntries = true)
    public void createNewSection(RestaurantMenu restaurantMenu) throws Exception {
        restaurantMenuService.save(restaurantMenu);
    }

    @Override
    @Cacheable(value = "menus", key = "#locale")
    public RestaurantMenu getMenuByLocale(String locale) throws Exception {
        return restaurantMenuService.findByLocale(locale);
    }

}
