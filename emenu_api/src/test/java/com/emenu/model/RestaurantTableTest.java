package com.emenu.model;

import org.junit.Assert;
import org.junit.Test;

import com.emenu.model.section.RestaurantTable;

/**
 * This is restaurant table test case.
 *
 * @author Simon Ghobreil.
 */
public class RestaurantTableTest {

    /**
     * Test method for {@link com.emenu.api.model.ResturantTable#getId(), @link
     * com.emenu.api.model.ResturantTable#setId(java.lang.Long)}.
     */
    @Test
    public void testSetterAndGetterId() {
        RestaurantTable resturantTable = new RestaurantTable();
        resturantTable.setId(1L);
        Assert.assertEquals(resturantTable.getId(), new Long(1));
    }

    /**
     * Test method for
     * {@link com.emenu.model.section.api.model.RestaurantTable#getTable_number() , @link
     * com.emenu.api.model.ResturantTable#setId(java.lang.Long)}.
     */
    @Test
    public void testGetterAndSetterTableNumber() {
        RestaurantTable resturantTable = new RestaurantTable();
        resturantTable.setTableNumber("table1");
        Assert.assertEquals(resturantTable.getTableNumber(), "table1");
    }

}
