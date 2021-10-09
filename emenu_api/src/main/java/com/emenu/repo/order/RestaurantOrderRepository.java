package com.emenu.repo.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emenu.model.order.RestaurantOrder;
import com.emenu.model.order.RestaurantOrderStatus;

/**
 * Restaurant order repository.
 *
 * @author Simon Ghobreil.
 */
public interface RestaurantOrderRepository extends CrudRepository<RestaurantOrder, Long> {

    @Query("from RestaurantOrder order where order.table.id=?1 and orderStatus !=?2")
    RestaurantOrder getActiveOrderByTable(Long tableId, RestaurantOrderStatus created);

}
