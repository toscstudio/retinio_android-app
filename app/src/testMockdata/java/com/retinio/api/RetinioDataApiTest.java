package com.retinio.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by championswimmer on 6/4/16.
 */
public class RetinioDataApiTest {

    @Test
    public void getStores_Works() {
        assertEquals("Eye Trends", RetinioDataApi.getStores().get(0).getName());
    }

}
