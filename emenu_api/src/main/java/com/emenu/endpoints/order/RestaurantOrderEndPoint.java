package com.emenu.endpoints.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emenu.model.order.RestaurantOrder;
import com.emenu.model.order.RestaurantSubOrder;
import com.emenu.services.order.IRestaurantOrderService;
import com.emenu.services.order.IRestaurantSubOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant order end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/menu/order")
@Api(value = "Restaurant Order EndPoint", produces = "application/json")
public class RestaurantOrderEndPoint {

    @Autowired
    private IRestaurantSubOrderService subOrderService;

    @Autowired
    private IRestaurantOrderService orderService;

    /**
     * Add new restaurant menu category.
     *
     * @param subOrder
     *        RestaurantSubOrder
     * @param tableId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِSubmit sub order")
    @RequestMapping(method = RequestMethod.POST, path = "/submitSubOrder", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantSubOrder> submitSubOrder(@RequestBody RestaurantSubOrder subOrder,
            @RequestParam Long tableId) {

        try {
            subOrderService.submitSubOrder(subOrder, tableId);
            return new ResponseEntity<>(subOrder, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get order by table id.
     *
     * @param tableId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِGet Order by table id")
    @RequestMapping(method = RequestMethod.GET, path = "/getOrderByTableId", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantOrder> getOrderByTableId(@RequestParam Long tableId) {

        try {
            return new ResponseEntity<>(orderService.getOrderByTableId(tableId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
