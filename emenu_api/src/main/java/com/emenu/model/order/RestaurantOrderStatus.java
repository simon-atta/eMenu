package com.emenu.model.order;

/**
 * Order status enum.
 *
 * @author Simon-PC
 */
public enum RestaurantOrderStatus {

    CREATED("created"), CONFRIMED("confrimed"), DONE("done");

    private final String reasonPhrase;

    private RestaurantOrderStatus(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getReasonPhrase() {
        return reasonPhrase;
    }

}
