package com.emenu.endpoints.section;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emenu.model.exceptions.SessionExists;
import com.emenu.model.exceptions.SessionNotExists;
import com.emenu.model.section.RestaurantTable;
import com.emenu.services.section.IRestaurantTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Restaurant tables end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/table")
@Api(value = "Restaurant Table EndPoint", produces = "application/json")
public class RestaurantTableEndPoint {

    @Autowired
    private IRestaurantTableService restaurantTableService;

    /**
     * Add new restaurant table.
     *
     * @param restaurantTable
     *        RestaurantTable
     * @return HTTP status indicate success or failure,
     */
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Restaurant Table request can't be empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @ApiOperation(value = "ِCreate new restaurant table")
    @RequestMapping(method = RequestMethod.POST,
                    path = "/createRestaurantTable",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<RestaurantTable> createRestaurantTable(
            @RequestBody RestaurantTable restaurantTable) {

        try {
            restaurantTableService.createNewTable(restaurantTable);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Start table session.
     *
     * @param waiterId
     *        Long
     * @param tableId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِStart Table Session")
    @RequestMapping(method = RequestMethod.POST, path = "/startTableSession", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> startTableSession(@RequestParam Long waiterId,
            @RequestParam Long tableId) {

        try {
            restaurantTableService.startTableSession(tableId, waiterId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (SessionExists exception) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * End table session.
     *
     * @param tableId
     *        Long
     * @return HTTP status indicate success or failure.
     */
    @ApiOperation(value = "ِEnd Table Session")
    @RequestMapping(method = RequestMethod.POST, path = "/endTableSession", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> endTableSession(@RequestParam Long tableId) {

        try {
            restaurantTableService.endTableSession(tableId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (SessionNotExists exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Add tables list with locale.
     *
     * @param locale
     *        String
     * @param listSize
     *        Integer
     * @return HTTP status indicate success or failure,
     */
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Restaurant Table request can't be empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @ApiOperation(value = "ِCreate new restaurant table")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantTableList", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> createRestaurantTableList(@RequestParam String locale,
            @RequestParam Integer listSize) {

        try {
            restaurantTableService.createNewTableList(locale, listSize);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all restaurant tables based on locale.
     *
     * @param locale
     *        String
     * @return list of table based on locale.
     */
    @ApiOperation(value = "Get all restaurant tables by locale")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllRestaurantTableByLocale", produces = "application/json")
    public @ResponseBody ResponseEntity<List<RestaurantTable>> getAllRestaurantTableByLocale(
            @RequestParam String locale) {
        try {
            return new ResponseEntity<>(restaurantTableService.getAllRestaurantTable(locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get restaurant table.
     *
     * @param locale
     *        String
     * @return list of table based on locale.
     */
    @ApiOperation(value = "Get restaurant table")
    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantTable", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> getRestaurantTable(@RequestParam String locale,
            @RequestParam String tableName) {
        try {
            return new ResponseEntity<>(restaurantTableService.getRestaurantTable(tableName, locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete all restaurant tables based on locale.
     *
     * @param locale
     *        String
     */
    @ApiOperation(value = "ِDelete all restaurant by locale")
    @RequestMapping(method = RequestMethod.DELETE,
                    path = "/deleteAllRestaurantTableByLocale",
                    produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> deleteAllRestaurantTableByLocale(@RequestParam String locale) {
        try {
            restaurantTableService.deleteAllRestaurantTable(locale);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
