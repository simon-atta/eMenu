package com.emenu.services.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emenu.model.menu.RestaurantMenu;
import com.emenu.model.menu.RestaurantMenuCategory;
import com.emenu.model.menu.dto.CategoryResponse;
import com.emenu.repo.menu.RestaurantMenuCategoryRepository;
import com.emenu.repo.menu.RestaurantMenuRepository;

/**
 * Restaurant menu category service which contains all business logic for
 * restaurant menu category.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "category")
public class RestaurantMenuCategoryService implements IRestaurantMenuCategoryService {

    @Autowired
    private RestaurantMenuCategoryRepository menuCategoryRepository;

    @Autowired
    private RestaurantMenuRepository menuRepository;

    @Override
    @CacheEvict(allEntries = true)
    public void createMenuCategory(RestaurantMenuCategory restaurantMenuCategory) throws Exception {
        menuCategoryRepository.save(restaurantMenuCategory);
    }

    @Override
    @Cacheable(value = "category", key = "#locale")
    public List<CategoryResponse> getCategoriesList(String locale) throws Exception {
        List<RestaurantMenuCategory> result = menuCategoryRepository.findByLocale(locale);
        List<CategoryResponse> results = new ArrayList<CategoryResponse>();
        for (RestaurantMenuCategory cat : result) {

            results.add(new CategoryResponse(cat.getId(), cat.getCatName(), cat.getLocale(), cat.getImagePath()));
        }

        return results;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void assignCategoryToMenu(Long menuId, Long catId) throws Exception {
        RestaurantMenu restaurantMenu = menuRepository.findOne(menuId);
        RestaurantMenuCategory menuCategory = menuCategoryRepository.findOne(catId);

        restaurantMenu.getCategories().add(menuCategory);
        menuRepository.save(restaurantMenu);
        menuCategory.setRestaurantMenu(restaurantMenu);
        menuCategoryRepository.save(menuCategory);
    }

}
