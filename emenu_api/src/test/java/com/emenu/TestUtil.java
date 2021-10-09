package com.emenu;

import java.util.ArrayList;
import java.util.List;

import com.emenu.model.section.RestaurantTable;

/**
 * @author Simon Ghobreil.
 */
public class TestUtil {

    public static RestaurantTable createNewRestaurantTable() {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setId(1L);
        restaurantTable.setTableNumber("table1");
        restaurantTable.setLocale("en");
        return restaurantTable;
    }

    public static List<RestaurantTable> getRestaurantTableList() {

        List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();

        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setTableNumber("table2");
        restaurantTable.setLocale("en");
        RestaurantTable restaurantTable2 = new RestaurantTable();
        restaurantTable2.setTableNumber("table3");
        restaurantTable.setLocale("en");
        restaurantTables.add(restaurantTable);
        restaurantTables.add(restaurantTable2);

        return restaurantTables;
    }

}
