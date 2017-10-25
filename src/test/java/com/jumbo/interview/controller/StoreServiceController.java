package com.jumbo.interview.controller;

import com.jumbo.interview.BaseTestContext;
import com.jumbo.interview.TestConstants;
import com.jumbo.interview.TestUtils;
import com.jumbo.interview.domain.Store;
import com.jumbo.interview.service.StoreService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class StoreServiceController extends BaseTestContext {
    @InjectMocks
    private StoreController underTest;

    @Mock
    private StoreService storeService;

    @Test
    public void shouldReturnClosestStores() {
        Mockito.when(storeService.getTopClosestStores(TestConstants.DEFAULT_LATITUDE, TestConstants.DEFAULT_LONGITUDE))
                .thenReturn(TestUtils.prepareStoreList(TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN));

        final List<Store> closestStores = underTest.getClosestStores(TestConstants.DEFAULT_LATITUDE, TestConstants.DEFAULT_LONGITUDE);

        Assert.assertNotNull(closestStores);
        Assert.assertEquals(TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN, closestStores.size());
    }
}