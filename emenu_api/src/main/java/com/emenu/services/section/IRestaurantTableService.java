package com.emenu.services.section;

import java.util.List;

import com.emenu.model.section.RestaurantTable;

/**
 * This is contract interface for all table services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantTableService {

    /**
     * Create new table.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param restaurantTable
     *        RestaurantTable
     * @throws Exception
     */
    void createNewTable(RestaurantTable restaurantTable) throws Exception;

    /**
     * Create new table list by locale.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param restaurantTable
     *        RestaurantTable
     * @throws Exception
     */
    void createNewTableList(String locale, Integer listSize) throws Exception;

    /**
     * Get restaurant table by table name and locale.
     *
     * @param tableName
     *        String
     * @param locale
     *        Locale
     * @return RestaurantTable
     * @throws Exception
     */
    RestaurantTable getRestaurantTable(String tableName, String locale) throws Exception;

    /**
     * Get all restaurant tables by locale.
     *
     * @param locale
     *        Locale
     * @return list of RestaurantTable
     * @throws Exception
     */
    List<RestaurantTable> getAllRestaurantTable(String locale) throws Exception;

    /**
     * Delete all restaurant tables by locale.
     *
     * @param locale
     *        Locale
     * @throws Exception
     */
    void deleteAllRestaurantTable(String locale) throws Exception;

    /**
     * Start table session.
     *
     * @param tableId
     *        Long
     * @param waiterId
     *        Long
     * @throws Exception
     */
    void startTableSession(Long tableId, Long waiterId) throws Exception;

    /**
     * End table session.
     *
     * @param tableId
     *        Long
     * @throws Exception
     */
    void endTableSession(Long tableId) throws Exception;

}
