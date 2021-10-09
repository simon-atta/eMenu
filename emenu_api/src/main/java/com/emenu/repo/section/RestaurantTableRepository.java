package com.emenu.repo.section;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.emenu.model.section.RestaurantTable;

/**
 * Restaurant Table repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Long> {

    RestaurantTable findByTableNumberAndLocale(String tableNumber, String locale);

    List<RestaurantTable> findByLocale(String locale);

    @Query("delete from RestaurantTable restTable where restTable.locale = ?1")
    @Modifying
    @Transactional
    void deleteByLocale(String locale);

}
