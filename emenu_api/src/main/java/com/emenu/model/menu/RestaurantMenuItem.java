package com.emenu.model.menu;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Restaurant menu item model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_menu_item")
public class RestaurantMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "locale")
    private String locale;

    private Double price;

    @OneToMany(mappedBy = "restaurantMenuItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantMenuItemImage> images;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    @JsonIgnore
    private RestaurantMenuCategory category;

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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     *        the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     *        the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the images
     */
    public List<RestaurantMenuItemImage> getImages() {
        return images;
    }

    /**
     * @param images
     *        the images to set
     */
    public void setImages(List<RestaurantMenuItemImage> images) {
        this.images = images;
    }

    /**
     * @return the category
     */
    public RestaurantMenuCategory getCategory() {
        return category;
    }

    /**
     * @param category
     *        the category to set
     */
    public void setCategory(RestaurantMenuCategory category) {
        this.category = category;
    }

}
