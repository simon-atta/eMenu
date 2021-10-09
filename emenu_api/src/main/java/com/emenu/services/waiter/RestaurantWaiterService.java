package com.emenu.services.waiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emenu.model.waiter.RestaurantWaiter;
import com.emenu.repo.waiter.RestaurantWaiterRepository;

/**
 * Restaurant waiter service which contains all business logic for restaurant
 * waiter.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "waiters")
public class RestaurantWaiterService implements IRestaurantWaiterService {

    @Autowired
    private RestaurantWaiterRepository restaurantWaiterRepository;

    @Override
    @CacheEvict(allEntries = true)
    public void createNewWaiter(RestaurantWaiter restaurantWaiter) {
        restaurantWaiterRepository.save(restaurantWaiter);
    }

    @Override
    @Cacheable(value = "waiters", key = "#id")
    public RestaurantWaiter getWaiterById(Long id, String locale) {
        return restaurantWaiterRepository.findOne(id);
    }

    @Override
    @Cacheable(value = "waiters", key = "#userName")
    public RestaurantWaiter getWaiterByUserName(String userName, String locale) {
        return restaurantWaiterRepository.findByUserName(userName);
    }

}
