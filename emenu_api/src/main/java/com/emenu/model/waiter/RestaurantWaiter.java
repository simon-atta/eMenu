package com.emenu.model.waiter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emenu.model.order.RestaurantOrder;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Restaurant waiter model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_waiter")
public class RestaurantWaiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "waiter_id")
    private Long id;

    @Column(name = "waiter_name")
    private String waiterName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "locale")
    private String locale;

    @OneToMany(mappedBy = "waiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<RestaurantOrder> orders;

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
     * @return the waiterName
     */
    public String getWaiterName() {
        return waiterName;
    }

    /**
     * @param waiterName
     *        the waiterName to set
     */
    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale
     *        the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *        the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the orders
     */
    public List<RestaurantOrder> getOrders() {
        return orders;
    }

    /**
     * @param orders
     *        the orders to set
     */
    public void setOrders(List<RestaurantOrder> orders) {
        this.orders = orders;
    }

}
