package com.emenu.repo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emenu.TestUtil;
import com.emenu.model.section.RestaurantTable;
import com.emenu.repo.section.RestaurantTableRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestaurantTableRepositoryTest {

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @Before
    public void setUp() throws Exception {
        restaurantTableRepository.save(TestUtil.createNewRestaurantTable());
    }

    @Test
    public void testFindByTableNumberAndLocale() {
        RestaurantTable restaurantTable = restaurantTableRepository.findByTableNumberAndLocale("table1", "en");
        Assert.assertEquals(restaurantTable.getTableNumber(), "table1");
    }

    @After
    public void cleanUp() throws Exception {
        RestaurantTable restaurantTable = restaurantTableRepository.findByTableNumberAndLocale("table1", "en");
        restaurantTableRepository.delete(restaurantTable);

    }

}