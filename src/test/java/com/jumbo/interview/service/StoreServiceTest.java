package com.jumbo.interview.service;

import com.jumbo.interview.BaseTestContext;
import com.jumbo.interview.TestConstants;
import com.jumbo.interview.domain.Store;
import com.jumbo.interview.TestUtils;
import com.jumbo.interview.repository.StoreRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class StoreServiceTest extends BaseTestContext {
    @InjectMocks
    private StoreService underTest;

    @Mock
    private StoreRepository storeRepository;

    @Before
    public void init() throws Exception {
        super.init();
        final Field numberOfStoresToReturn = StoreService.class.getDeclaredField("numberOfStoresToReturn");
        numberOfStoresToReturn.setAccessible(true);
        ReflectionUtils.setField(numberOfStoresToReturn, underTest, TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN);
    }

    @Test
    public void shouldReturnClosestStores() {
        Mockito.when(storeRepository.findTopClosestStoresByLatitudeAndLongitude(TestConstants.DEFAULT_LATITUDE, TestConstants.DEFAULT_LONGITUDE,
                TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN)).thenReturn(TestUtils.prepareStoreList(TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN));

        final List<Store> closestStores = underTest.getTopClosestStores(TestConstants.DEFAULT_LATITUDE, TestConstants.DEFAULT_LONGITUDE);

        Assert.assertNotNull(closestStores);
        Assert.assertEquals(TestConstants.DEFAULT_NUMBER_OF_STORES_TO_RETURN, closestStores.size());
    }
}
