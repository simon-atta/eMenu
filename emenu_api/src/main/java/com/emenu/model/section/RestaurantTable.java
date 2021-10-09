package com.emenu.model.section;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emenu.model.order.RestaurantOrder;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Restaurant table model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private Long id;

    @Column(name = "table_number")
    private String tableNumber;

    @Column(name = "locale")
    private String locale;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    @JsonBackReference(value = "restaurantTables")
    private RestaurantSection restaurantSection;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "table")
    private List<RestaurantOrder> orders;

    public RestaurantTable() {
    }

    /**
     * @param id
     * @param tableNumber
     * @param locale
     */
    public RestaurantTable(String tableNumber, String locale) {
        super();
        this.tableNumber = tableNumber;
        this.locale = locale;
    }

    /**
     * @param id
     * @param tableNumber
     * @param locale
     * @param restaurantSection
     */
    public RestaurantTable(Long id, String tableNumber, String locale, RestaurantSection restaurantSection) {
        super();
        this.id = id;
        this.tableNumber = tableNumber;
        this.locale = locale;
        this.restaurantSection = restaurantSection;
    }

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
     * @return the tableNumber
     */
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * @param tableNumber
     *        the tableNumber to set
     */
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
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
     * @return the restaurantSection
     */
    public RestaurantSection getRestaurantSection() {
        return restaurantSection;
    }

    /**
     * @param restaurantSection
     *        the restaurantSection to set
     */
    public void setRestaurantSection(RestaurantSection restaurantSection) {
        this.restaurantSection = restaurantSection;
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
