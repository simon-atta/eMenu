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
 * Restaurant menu category model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_menu_category")
public class RestaurantMenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private Long id;

    @Column(name = "menu_name")
    private String catName;

    @Column(name = "locale")
    private String locale;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private RestaurantMenu restaurantMenu;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantMenuItem> items;

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
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName
     *        the catName to set
     */
    public void setCatName(String catName) {
        this.catName = catName;
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
     * @return the restaurantMenu
     */
    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    /**
     * @param restaurantMenu
     *        the restaurantMenu to set
     */
    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    /**
     * @return the items
     */
    public List<RestaurantMenuItem> getItems() {
        return items;
    }

    /**
     * @param items
     *        the items to set
     */
    public void setItems(List<RestaurantMenuItem> items) {
        this.items = items;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath
     *        the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
