package com.emenu.repo.order;

import org.springframework.data.repository.CrudRepository;

import com.emenu.model.order.RestaurantSubOrder;

/**
 * Restaurant sub order repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantSubOrderRepository extends CrudRepository<RestaurantSubOrder, Long> {

}
