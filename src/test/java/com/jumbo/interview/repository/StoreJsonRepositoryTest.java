package com.jumbo.interview.repository;

import com.jumbo.interview.BaseTestContext;
import com.jumbo.interview.TestConstants;
import com.jumbo.interview.TestUtils;
import com.jumbo.interview.domain.Store;
import com.jumbo.interview.repository.impl.StoreJsonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoreJsonRepositoryTest extends BaseTestContext {
    @InjectMocks
    private StoreJsonRepository underTest;

    @Spy
    private Set<Store> stores = new HashSet<>(TestUtils.prepareStoreList(10));;

    @Test
    public void shouldFindTopClosestStoresWithGivenNumber(){
        final List<Store> closestStores = underTest.findTopClosestStoresByLatitudeAndLongitude(TestConstants.DEFAULT_LATITUDE,
                TestConstants.DEFAULT_LONGITUDE, TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN);

        Assert.assertNotNull(closestStores);
        Assert.assertEquals(TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN, closestStores.size());
    }

    @Test
    public void shouldFindClosestStore(){
        final List<Store> closestStores = underTest.findTopClosestStoresByLatitudeAndLongitude(TestConstants.DEFAULT_LATITUDE,
                TestConstants.DEFAULT_LONGITUDE, TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN);

        Assert.assertNotNull(closestStores);

        Store closestStore = closestStores.get(0);

        Assert.assertEquals(TestConstants.DEFAULT_LATITUDE, Double.valueOf(closestStore.getLatitude()), 0);
        Assert.assertEquals(TestConstants.DEFAULT_LONGITUDE, Double.valueOf(closestStore.getLongitude()), 0);
    }
}
