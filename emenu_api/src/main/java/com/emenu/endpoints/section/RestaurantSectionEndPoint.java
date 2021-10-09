package com.emenu.endpoints.section;

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

import com.emenu.model.section.RestaurantSection;
import com.emenu.model.section.RestaurantTable;
import com.emenu.services.section.IRestaurantSectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant section end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/emenu/section")
@Api(value = "Restaurant Section EndPoint", produces = "application/json")
public class RestaurantSectionEndPoint {

    @Autowired
    private IRestaurantSectionService restaurantSectionService;

    /**
     * Add new restaurant section.
     *
     * @param restaurantSection
     *        RestaurantSection
     * @return HTTP status indicate success or failure,
     */
    @ApiOperation(value = "ِCreate new restaurant section")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantSection", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantSection> createRestaurantSection(
            @RequestBody RestaurantSection restaurantSection) {

        try {
            restaurantSectionService.createNewSection(restaurantSection);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create restaurant section list with specific locale.
     *
     * @param locale
     *        String
     * @param listSize
     *        Integer
     *        * @return HTTP status indicate success or failure,
     */
    @ApiOperation(value = "ِCreate new restaurant section list")
    @RequestMapping(method = RequestMethod.POST, path = "/createRestaurantSectionList", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> createRestaurantSectionList(@RequestParam String locale,
            @RequestParam Integer listSize) {

        try {
            restaurantSectionService.createNewSectionList(locale, listSize);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create restaurant section list of resturant section list with specific
     * locale.
     *
     * @param locale
     *        String
     * @param listSize
     *        Integer
     *        * @return HTTP status indicate success or failure,
     */
    @ApiOperation(value = "ِCreate new restaurant section list with tables")
    @RequestMapping(method = RequestMethod.POST,
                    path = "/createRestaurantSectionListWithTables",
                    produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantTable> createRestaurantSectionListWithTables(
            @RequestBody List<RestaurantSection> restaurantSections) {

        try {
            restaurantSectionService.createNewSectionListWithTables(restaurantSections);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all restaurant section based on locale.
     *
     * @param locale
     *        String
     * @return list of table based on locale.
     */
    @ApiOperation(value = "Get all restaurant sections with tables by locale")
    @RequestMapping(method = RequestMethod.GET,
                    path = "/getAllRestaurantSectionsByLocale",
                    produces = "application/json")
    public @ResponseBody ResponseEntity<List<RestaurantSection>> getAllRestaurantSectionsByLocale(
            @RequestParam String locale) {
        try {
            return new ResponseEntity<>(restaurantSectionService.getAllRestaurantSection(locale), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get section details by id and locale.
     *
     * @param locale
     *        String
     * @param id
     *        Long
     * @return Restaurant section with tables.
     */
    @ApiOperation(value = "Get section details by id and locale")
    @RequestMapping(method = RequestMethod.GET, path = "/getSectionDetailsByIdAndLocale", produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantSection> getSectionDetailsByIdAndLocale(@RequestParam String locale,
            @RequestParam Long id) {
        try {
            return new ResponseEntity<>(restaurantSectionService.getSectionDetails(locale, id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete all restaurant section based on locale.
     *
     * @param locale
     *        String
     */
    @ApiOperation(value = "ِDelete all restaurant sections by locale")
    @RequestMapping(method = RequestMethod.DELETE,
                    path = "/deleteAllRestaurantTableByLocale",
                    produces = "application/json")
    public @ResponseBody ResponseEntity<RestaurantSection> deleteAllRestaurantTableByLocale(
            @RequestParam String locale) {
        try {
            restaurantSectionService.deleteAllRestaurantSections(locale);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
