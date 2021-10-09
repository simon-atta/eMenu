package com.emenu.model.menu;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Restaurant menu item image model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "restaurant_menu_item_image")
public class RestaurantMenuItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image_main")
    private Boolean mainImage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private RestaurantMenuItem restaurantMenuItem;

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

    /**
     * @return the mainImage
     */
    public Boolean getMainImage() {
        return mainImage;
    }

    /**
     * @param mainImage
     *        the mainImage to set
     */
    public void setMainImage(Boolean mainImage) {
        this.mainImage = mainImage;
    }

}
