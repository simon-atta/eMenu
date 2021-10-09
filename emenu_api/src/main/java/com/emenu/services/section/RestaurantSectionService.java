package com.emenu.services.section;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emenu.model.section.RestaurantSection;
import com.emenu.repo.section.RestaurantSectionRepository;

/**
 * Restaurant section service which contains all business logic for restaurant
 * sections.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "sections")
public class RestaurantSectionService implements IRestaurantSectionService {

    public static final String KEY_SECTION = "cacheKey";
    public static final String KEY_SECTION_TABLES = "cacheTables";

    @Autowired
    private RestaurantSectionRepository restSectionRepository;

    @Override
    @CacheEvict(allEntries = true)
    public void createNewSection(RestaurantSection restaurantSection) throws Exception {
        restSectionRepository.save(restaurantSection);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void createNewSectionList(String locale, Integer listSize) throws Exception {
        List<RestaurantSection> restaurantSectionList = new ArrayList<RestaurantSection>();
        RestaurantSection restaurantSection = null;
        for (int i = 1; i < listSize + 1; i++) {
            restaurantSection = new RestaurantSection("table" + i, locale);
            restaurantSectionList.add(restaurantSection);
        }

        restSectionRepository.save(restaurantSectionList);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void createNewSectionListWithTables(List<RestaurantSection> restaurantSections) throws Exception {
        restSectionRepository.save(restaurantSections);
    }

    @Override
    @Cacheable(value = "sections", key = "#root.target.KEY_SECTION_TABLES")
    public List<RestaurantSection> getAllRestaurantSection(String locale) throws Exception {
        return restSectionRepository.getAllSections(locale);
    }

    @Override
    @Cacheable(value = "sections", key = "#id")
    public RestaurantSection getSectionDetails(String locale, Long id) throws Exception {
        return restSectionRepository.getSectionDetails(id, locale);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteAllRestaurantSections(String locale) throws Exception {
        restSectionRepository.deleteByLocale(locale);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteSectionByIdAndLocale(Long id, String locale) throws Exception {
        restSectionRepository.deleteByLocaleAndId(id, locale);
    }

}
