package com.emenu.repo.section;

import org.springframework.data.repository.CrudRepository;

import com.emenu.model.section.RestaurantTableSession;

/**
 * Restaurant table session repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantTableSessionRepository extends CrudRepository<RestaurantTableSession, Long> {

    RestaurantTableSession findByStatus(String status);

}
