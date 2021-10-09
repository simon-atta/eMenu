package com.emenu.repo.waiter;

import org.springframework.data.repository.CrudRepository;

import com.emenu.model.waiter.RestaurantWaiter;

/**
 * Restaurant waiter repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantWaiterRepository extends CrudRepository<RestaurantWaiter, Long> {

    RestaurantWaiter findByUserName(String userName);

}
