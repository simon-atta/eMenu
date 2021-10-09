package com.emenu.endpoints.waiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emenu.model.waiter.RestaurantWaiter;
import com.emenu.services.waiter.IRestaurantWaiterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant waiter end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/waiter")
@Api(value = "Restaurant Waiter EndPoint", produces = "application/json")
public class RestaurantWaiterEndPoint {

    @Autowired
    private IRestaurantWaiterService restaurantWaiterService;

    /**
     * Add new restaurant menu.
     *
     * @param restaurantMenu
     *        RestaurantMenu
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِCreate new restaurant waiter")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantWaiter", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantWaiter> createRestaurantWaiter(
            @RequestBody RestaurantWaiter restaurantWaiter) {

        try {
            restaurantWaiterService.createNewWaiter(restaurantWaiter);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get waiter by id.
     *
     * @param id
     *        Long
     * @param locale
     *        String
     * @return waiter match query parameters.
     */
    @ApiOperation(value = "Get waiter by id")
    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantWaiterById", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantWaiter> getRestaurantWaiterById(@RequestParam Long id,
            @RequestParam String locale) {
        try {
            return new ResponseEntity<>(restaurantWaiterService.getWaiterById(id, locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get waiter by user name.
     *
     * @param user
     *        name
     *        String
     * @param locale
     *        String
     * @return waiter match query parameters.
     */
    @ApiOperation(value = "Get waiter by user name")
    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantWaiterByUserName", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantWaiter> getRestaurantWaiterByUserName(@RequestParam String userName,
            @RequestParam String locale) {
        try {
            return new ResponseEntity<>(restaurantWaiterService.getWaiterByUserName(userName, locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
