package com.emenu.model.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emenu.model.section.RestaurantTable;
import com.emenu.model.waiter.RestaurantWaiter;

/**
 * Restaurant order model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_order")
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    private RestaurantOrderStatus orderStatus;

    @Column(name = "order_total")
    private Double orderTotal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "waiter_id")
    private RestaurantWaiter waiter;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id")
    private RestaurantTable table;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantSubOrder> subOrders;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber
     *        the orderNumber to set
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the orderStatus
     */
    public RestaurantOrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus
     *        the orderStatus to set
     */
    public void setOrderStatus(RestaurantOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the orderTotal
     */
    public Double getOrderTotal() {
        return orderTotal;
    }

    /**
     * @param orderTotal
     *        the orderTotal to set
     */
    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * @return the waiter
     */
    public RestaurantWaiter getWaiter() {
        return waiter;
    }

    /**
     * @param waiter
     *        the waiter to set
     */
    public void setWaiter(RestaurantWaiter waiter) {
        this.waiter = waiter;
    }

    /**
     * @return the table
     */
    public RestaurantTable getTable() {
        return table;
    }

    /**
     * @param table
     *        the table to set
     */
    public void setTable(RestaurantTable table) {
        this.table = table;
    }

    /**
     * @return the subOrders
     */
    public List<RestaurantSubOrder> getSubOrders() {
        return subOrders;
    }

    /**
     * @param subOrders
     *        the subOrders to set
     */
    public void setSubOrders(List<RestaurantSubOrder> subOrders) {
        this.subOrders = subOrders;
    }

}
