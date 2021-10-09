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
import com.emenu.model.menu.RestaurantMenuItem;
import com.emenu.services.menu.IRestaurantMenuItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant menu item end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/menu/item")
@Api(value = "Restaurant Menu Item EndPoint", produces = "application/json")
public class RestaurantMenuItemEndPoint {

    @Autowired
    private IRestaurantMenuItemService menuItemService;

    /**
     * Add new restaurant menu item.
     *
     * @param restaurantMenuItem
     *        RestaurantMenuItem
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِCreate new restaurant menu category")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantMenuItem", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenuItem> createRestaurantMenuItem(
            @RequestBody RestaurantMenuItem restaurantMenuItem) {

        try {
            menuItemService.createMenuItem(restaurantMenuItem);
            return new ResponseEntity<RestaurantMenuItem>(restaurantMenuItem, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<RestaurantMenuItem>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get menu category based on locale and menu id.
     *
     * @param locale
     *        String
     * @param catId
     *        Long
     * @return list of item based on category id.
     */
    @ApiOperation(value = "Get menu item belong to cat id")
    @RequestMapping(method = RequestMethod.GET, path = "/getCategoryItemsByLocale", produces = "application/json")
    public @ResponseBody ResponseEntity<List<RestaurantMenuItem>> getCategoryItemsByLocale(@RequestParam Long catId,
            @RequestParam String locale) {
        try {
            return new ResponseEntity<>(menuItemService.getCategoryItemList(catId, locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Assign item to category.
     *
     * @param itemId
     *        Long
     * @param catId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "Assign menu category to menu by locale")
    @RequestMapping(method = RequestMethod.PUT, path = "/assignItemToCategory", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenuCategory> assignItemToCategory(@RequestParam Long itemId,
            @RequestParam Long catId) {
        try {
            menuItemService.assignItemToCategoryMenu(itemId, catId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get menu item details.
     *
     * @param locale
     *        String
     * @param catId
     *        Long
     * @param itemId
     *        Long
     * @return item details.
     */
    @ApiOperation(value = "Get menu item details")
    @RequestMapping(method = RequestMethod.GET, path = "/getItemsDetailsByLocale", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenuItem> getItemsDetailsByLocale(@RequestParam Long catId,
            @RequestParam Long itemId, @RequestParam String locale) {
        try {
            return new ResponseEntity<>(menuItemService.getMenuItemDetails(catId, itemId, locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
