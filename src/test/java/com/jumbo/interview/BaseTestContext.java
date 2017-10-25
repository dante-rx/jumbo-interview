package com.jumbo.interview;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class BaseTestContext {
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
