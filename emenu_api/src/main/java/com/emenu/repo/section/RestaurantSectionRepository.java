package com.emenu.repo.section;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.emenu.model.section.RestaurantSection;

/**
 * Restaurant section repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantSectionRepository extends CrudRepository<RestaurantSection, Long> {

    List<RestaurantSection> findByLocale(String locale);

    @Query("select section_name,id from RestaurantSection section where section.locale = ?1")
    List<RestaurantSection> getAllSections(String locale);

    @Query("from RestaurantSection section where section.id=?1 and section.locale = ?2")
    RestaurantSection getSectionDetails(Long id, String locale);

    RestaurantSection findBySectionNameAndLocale(String sectionName, String locale);

    @Query("delete from RestaurantSection section where section.locale = ?1")
    @Modifying
    @Transactional
    void deleteByLocale(String locale);

    @Query("delete from RestaurantSection section where section.id=?1 and section.locale = ?2")
    @Modifying
    @Transactional
    void deleteByLocaleAndId(Long id, String locale);
}
