package com.emenu.model.menu;

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

/**
 * Restaurant menu model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_menu")
public class RestaurantMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "locale")
    private String locale;

    @OneToMany(mappedBy = "restaurantMenu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantMenuCategory> categories;

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
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     *        the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
     * @return the categories
     */
    public List<RestaurantMenuCategory> getCategories() {
        return categories;
    }

    /**
     * @param categories
     *        the categories to set
     */
    public void setCategories(List<RestaurantMenuCategory> categories) {
        this.categories = categories;
    }

}
