package com.emenu.services.section;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emenu.model.exceptions.SessionExists;
import com.emenu.model.exceptions.SessionNotExists;
import com.emenu.model.order.RestaurantOrder;
import com.emenu.model.order.RestaurantOrderStatus;
import com.emenu.model.section.RestaurantTable;
import com.emenu.model.section.RestaurantTableSession;
import com.emenu.repo.order.RestaurantOrderRepository;
import com.emenu.repo.section.RestaurantTableRepository;
import com.emenu.repo.section.RestaurantTableSessionRepository;
import com.emenu.repo.waiter.RestaurantWaiterRepository;

/**
 * Restaurant table service which contains all business logic for restaurant
 * table.
 *
 * @author Simon Ghobreil.
 */
@Service
@CacheConfig(cacheNames = "tables")
public class RestaurantTableService implements IRestaurantTableService {

    @Autowired
    private RestaurantTableRepository tableRepository;

    @Autowired
    private RestaurantTableSessionRepository tableSessionRepository;

    @Autowired
    private RestaurantOrderRepository orderRepository;

    @Autowired
    private RestaurantWaiterRepository waiterRepository;

    @Override
    @CacheEvict(allEntries = true)
    public void createNewTable(RestaurantTable restaurantTable) {
        tableRepository.save(restaurantTable);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void createNewTableList(String locale, Integer listSize) {

        List<RestaurantTable> restaurantTableList = new ArrayList<>();
        RestaurantTable restaurantTable = null;
        for (int i = 1; i < listSize + 1; i++) {
            restaurantTable = new RestaurantTable("table" + i, locale);
            restaurantTableList.add(restaurantTable);
        }

        tableRepository.save(restaurantTableList);
    }

    @Override
    @Cacheable(value = "tables", key = "#tableNumber")
    public RestaurantTable getRestaurantTable(String tableNumber, String locale) {
        return tableRepository.findByTableNumberAndLocale(tableNumber, locale);
    }

    @Override
    @Cacheable(value = "tables")
    public List<RestaurantTable> getAllRestaurantTable(String locale) {
        return tableRepository.findByLocale(locale);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteAllRestaurantTable(String locale) {
        tableRepository.deleteByLocale(locale);
    }

    @Override
    @Transactional
    public void startTableSession(Long tableId, Long waiterId) throws Exception {
        RestaurantTableSession restaurantTableSession = tableSessionRepository.findByStatus("ONLINE");

        if (restaurantTableSession != null) {
            throw new SessionExists();
        }

        RestaurantTableSession tableSession = new RestaurantTableSession(tableId, waiterId, "ONLINE", new Date());
        tableSessionRepository.save(tableSession);

        RestaurantOrder order = new RestaurantOrder();
        order.setOrderNumber(getOrderId(tableId, waiterId));
        order.setOrderStatus(RestaurantOrderStatus.CREATED);
        order.setTable(tableRepository.findOne(tableId));
        order.setWaiter(waiterRepository.findOne(waiterId));

        orderRepository.save(order);

    }

    private String getOrderId(Long tableId, Long waiterId) {
        StringBuilder orderId = new StringBuilder();
        orderId.append("ORD");
        orderId.append(tableId);
        orderId.append(waiterId);
        orderId.append(orderRepository.count() + 1);
        return orderId.toString();
    }

    @Override
    @Transactional
    public void endTableSession(Long tableId) throws Exception {
        RestaurantTableSession restaurantTableSession = tableSessionRepository.findByStatus("ONLINE");

        if (restaurantTableSession == null) {
            throw new SessionNotExists();
        }

        restaurantTableSession.setStatus("OFFLINE");
        restaurantTableSession.setEndTimeStamp(new Date());
        tableSessionRepository.save(restaurantTableSession);

        // TODO handle status of order and sub-orders
        RestaurantOrder order = orderRepository.getActiveOrderByTable(tableId, RestaurantOrderStatus.CREATED);
        order.setOrderStatus(RestaurantOrderStatus.DONE);
        orderRepository.save(order);

    }

}
