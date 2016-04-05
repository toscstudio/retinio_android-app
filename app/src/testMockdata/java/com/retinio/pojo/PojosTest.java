package com.retinio.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by championswimmer on 6/4/16.
 */
public class PojosTest {

    private Store store;

    @Before
    public void createPojos() {
        store = new Store();
        store.setName("Store Name");
        store.setAddress("Store Address");
    }

    @Test
    public void testStorePojo() {
        assertEquals("Store Name", store.getName());
        assertEquals("Store Address", store.getAddress());
    }
}
