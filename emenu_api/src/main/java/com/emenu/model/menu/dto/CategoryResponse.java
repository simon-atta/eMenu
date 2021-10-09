/**
 *
 */
package com.emenu.model.menu.dto;

/**
 * @author Simon-PC
 */
public class CategoryResponse {

    private Long id;

    private String catName;

    private String locale;

    private String imagePath;

    public CategoryResponse() {

    }

    /**
     * @param id
     * @param catName
     * @param locale
     * @param imagePath
     */
    public CategoryResponse(Long id, String catName, String locale, String imagePath) {
        super();
        this.id = id;
        this.catName = catName;
        this.locale = locale;
        this.imagePath = imagePath;
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
