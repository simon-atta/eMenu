package com.emenu.model.section;

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
 * Restaurant section model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_section")
public class RestaurantSection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "section_id")
    private Long id;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "locale")
    private String locale;

    @OneToMany(mappedBy = "restaurantSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantTable> restaurantTables;

    public RestaurantSection() {
    }

    /**
     * @param sectionName
     * @param locale
     */
    public RestaurantSection(String sectionName, String locale) {
        super();
        this.sectionName = sectionName;
        this.locale = locale;
    }

    /**
     * @param id
     * @param sectionName
     * @param locale
     * @param restaurantTables
     */
    public RestaurantSection(Long id, String sectionName, String locale, List<RestaurantTable> restaurantTables) {
        super();
        this.id = id;
        this.sectionName = sectionName;
        this.locale = locale;
        this.restaurantTables = restaurantTables;
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
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName
     *        the sectionName to set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
     * @return the restaurantTables
     */
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    /**
     * @param restaurantTables
     *        the restaurantTables to set
     */
    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

}
