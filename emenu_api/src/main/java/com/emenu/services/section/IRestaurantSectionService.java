package com.emenu.services.section;

import java.util.List;

import com.emenu.model.section.RestaurantSection;

/**
 * This is contract interface for all section services methods.
 *
 * @author Simon Ghobreil.
 */
public interface IRestaurantSectionService {

    /**
     * Create new section.
     * <p>
     * this method will evict cache with every time insert new section
     * table.
     *
     * @param restaurantSection
     *        RestaurantSection
     * @throws Exception
     */
    void createNewSection(RestaurantSection restaurantSection) throws Exception;

    /**
     * * Create new sections list by locale.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param locale
     *        String
     * @param listSize
     *        Integer
     * @throws Exception
     */
    void createNewSectionList(String locale, Integer listSize) throws Exception;

    /**
     * * Create new sections list with tables by locale.
     * <p>
     * this method will evict cache with every time insert new restaurant
     * table.
     *
     * @param restaurantSections
     *        List<RestaurantSection>
     * @throws Exception
     */
    void createNewSectionListWithTables(List<RestaurantSection> restaurantSections) throws Exception;

    /**
     * Get all restaurant section by locale.
     *
     * @param locale
     *        Locale
     * @return list of RestaurantSection
     * @throws Exception
     */
    List<RestaurantSection> getAllRestaurantSection(String locale) throws Exception;

    /**
     * Get section details by id and locale.
     *
     * @param locale
     *        Locale
     * @param id
     *        Long
     * @return list of RestaurantSection
     * @throws Exception
     */
    RestaurantSection getSectionDetails(String locale, Long id) throws Exception;

    /**
     * Delete all Restaurant Section tables by locale.
     *
     * @param locale
     *        Locale
     * @throws Exception
     */
    void deleteAllRestaurantSections(String locale) throws Exception;

    /**
     * Delete section by id and locale.
     *
     * @param locale
     *        Locale
     * @param id
     *        Long
     * @throws Exception
     */
    void deleteSectionByIdAndLocale(Long id, String locale) throws Exception;

}
