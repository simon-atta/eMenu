package com.emenu.endpoints.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emenu.model.menu.RestaurantMenu;
import com.emenu.services.menu.IRestaurantMenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant menu end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/menu")
@Api(value = "Restaurant Menu EndPoint", produces = "application/json")
public class RestaurantMenuEndPoint {

    @Autowired
    private IRestaurantMenuService restaurantMenuService;

    /**
     * Add new restaurant menu.
     *
     * @param restaurantMenu
     *        RestaurantMenu
     * @return HTTP status indicate success or failure,
     */
    @ApiOperation(value = "ِCreate new restaurant menu")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantMenu", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenu> createRestaurantMenu(
            @RequestBody RestaurantMenu restaurantMenu) {

        try {
            restaurantMenuService.createNewSection(restaurantMenu);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get menu based on locale.
     *
     * @param locale
     *        String
     * @return list of table based on locale.
     */
    @ApiOperation(value = "Get menu by locale")
    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantMenuByLocale", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantMenu> getRestaurantMenuByLocale(@RequestParam String locale) {
        try {
            return new ResponseEntity<>(restaurantMenuService.getMenuByLocale(locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
