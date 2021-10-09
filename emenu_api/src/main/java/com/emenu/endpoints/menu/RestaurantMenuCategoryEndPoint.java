package com.emenu.endpoints.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emenu.model.menu.RestaurantMenuCategory;
import com.emenu.model.menu.dto.CategoryResponse;
import com.emenu.services.menu.IRestaurantMenuCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant menu end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/menu/category")
@Api(value = "Restaurant Menu Category EndPoint", produces = "application/json")
public class RestaurantMenuCategoryEndPoint {

    @Autowired
    private IRestaurantMenuCategoryService menuCategoryService;

    /**
     * Add new restaurant menu category.
     *
     * @param restaurantMenuCategory
     *        RestaurantMenuCategory
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِCreate new restaurant menu category")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantMenuCategory", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenuCategory> createRestaurantMenuCategory(
            @RequestBody RestaurantMenuCategory restaurantMenuCategory) {

        try {
            menuCategoryService.createMenuCategory(restaurantMenuCategory);
            return new ResponseEntity<>(restaurantMenuCategory, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all categories based on locale.
     *
     * @param locale
     *        String
     * @return list of table based on locale.
     */
    @ApiOperation(value = "Get menu category by locale")
    @RequestMapping(method = RequestMethod.GET, path = "/getCategoriesList", produces = "application/json")
    public @ResponseBody ResponseEntity<List<CategoryResponse>> getCategoriesList(@RequestParam String locale) {
        try {
            return new ResponseEntity<>(menuCategoryService.getCategoriesList(locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Assign category for menu.
     *
     * @param catId
     *        Long
     * @param menuId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "Assign menu category to menu by locale")
    @RequestMapping(method = RequestMethod.PUT, path = "/assignCategoryToMenu", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenuCategory> assignCategoryToMenu(@RequestParam Long menuId,
            @RequestParam Long catId) {
        try {
            menuCategoryService.assignCategoryToMenu(menuId, catId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
