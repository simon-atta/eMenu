package com.emenu.services.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emenu.model.menu.RestaurantMenuCategory;
import com.emenu.model.menu.RestaurantMenuItem;
import com.emenu.repo.menu.RestaurantMenuCategoryRepository;
import com.emenu.repo.menu.RestaurantMenuItemRepository;

/**
 * Restaurant menu items service which contains all business logic for
 * restaurant menu item.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "items")
public class RestaurantMenuItemService implements IRestaurantMenuItemService {

    @Autowired
    private RestaurantMenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantMenuCategoryRepository menuCategoryRepository;

    @Override
    @CacheEvict(allEntries = true)
    public void createMenuItem(RestaurantMenuItem restaurantMenuItem) throws Exception {
        menuItemRepository.save(restaurantMenuItem);
    }

    @Override
    @Cacheable(value = "items", key = "#catId")
    public List<RestaurantMenuItem> getCategoryItemList(Long catId, String locale) throws Exception {
        return menuItemRepository.getCategoryItems(catId, locale);
    }

    @Override
    @Cacheable(value = "items", key = "#itemId")
    public RestaurantMenuItem getMenuItemDetails(Long catId, Long itemId, String locale) throws Exception {
        return menuItemRepository.getMenuItemDetails(catId, itemId, locale);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void assignItemToCategoryMenu(Long itemId, Long catId) throws Exception {
        RestaurantMenuCategory menuCategory = menuCategoryRepository.findOne(catId);

        RestaurantMenuItem menuItem = menuItemRepository.findOne(itemId);

        menuCategory.getItems().add(menuItem);
        menuCategoryRepository.save(menuCategory);
        menuItem.setCategory(menuCategory);
        menuItemRepository.save(menuItem);
    }

}
