package com.emenu.model.order;

import java.util.Date;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "restaurant_suborder")
public class RestaurantSubOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "suborder_id")
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "submition_date")
    private Date submitionDate;

    @Enumerated(EnumType.STRING)
    private RestaurantOrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private RestaurantOrder order;

    // private List<RestaurantOrderLine> orderLines;

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
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     *        the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the submitionDate
     */
    public Date getSubmitionDate() {
        return submitionDate;
    }

    /**
     * @param submitionDate
     *        the submitionDate to set
     */
    public void setSubmitionDate(Date submitionDate) {
        this.submitionDate = submitionDate;
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
     * @return the order
     */
    public RestaurantOrder getOrder() {
        return order;
    }

    /**
     * @param order
     *        the order to set
     */
    public void setOrder(RestaurantOrder order) {
        this.order = order;
    }

}
