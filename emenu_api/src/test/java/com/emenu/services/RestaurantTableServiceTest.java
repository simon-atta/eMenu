package com.emenu.services;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emenu.TestUtil;
import com.emenu.model.section.RestaurantTable;
import com.emenu.repo.section.RestaurantTableRepository;
import com.emenu.services.section.RestaurantTableService;

/**
 * Backup configuration service test cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestaurantTableServiceTest {

    @InjectMocks
    private RestaurantTableService restaurantTableService;

    @Mock
    private RestaurantTableRepository restaurantTableRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.emenu.services.section.api.services.RestaurantTableService#createNewTable(com.emenu.model.section.api.model.RestaurantTable)}.
     *
     * @throws Exception
     */
    @Test
    public void testCreateNewTable() throws Exception {

        RestaurantTable restaurantTable = TestUtil.createNewRestaurantTable();

        when(restaurantTableRepository.save(any(RestaurantTable.class))).thenReturn(restaurantTable);

        restaurantTableService.createNewTable(restaurantTable);

        verify(restaurantTableRepository, times(1)).save(restaurantTable);
        verifyNoMoreInteractions(restaurantTableRepository);
    }

    /**
     * Test method for
     * {@link com.emenu.services.section.api.services.RestaurantTableService#getRestaurantTable(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetRestaurantTable() throws Exception {

        RestaurantTable restaurantTable = TestUtil.createNewRestaurantTable();

        when(restaurantTableRepository.findByTableNumberAndLocale(Mockito.anyString(), Mockito.anyObject()))
                .thenReturn(restaurantTable);

        RestaurantTable restaurantTableSer = restaurantTableService.getRestaurantTable("table", "en");

        Assert.assertEquals(restaurantTable.getId(), restaurantTableSer.getId());
        Assert.assertEquals(restaurantTable.getTableNumber(), restaurantTableSer.getTableNumber());
    }

    /**
     * Test method for
     * {@link com.emenu.services.section.api.services.RestaurantTableService#getRestaurantTable(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAllRestaurantTable() throws Exception {

        List<RestaurantTable> restaurantTables = TestUtil.getRestaurantTableList();

        when(restaurantTableRepository.findByLocale(Mockito.anyObject())).thenReturn(restaurantTables);

        List<RestaurantTable> restaurantTableSers = restaurantTableService.getAllRestaurantTable("en");

        Assert.assertEquals(restaurantTableSers.size(), restaurantTables.size());
    }

}
