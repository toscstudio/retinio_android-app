package com.retinio.api;

import com.retinio.pojo.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by championswimmer on 6/4/16.
 */
public class RetinioDataApi {

    public static List<Store> getStores() {
        List<Store> storeList = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            Store s = new Store();
            s.setName("Eye Trends");
            s.setAddress("B-1/113, Rohini, New Delhi");
            s.setBuyAvailable(true);
            s.setDocAvailable(true);
            s.setOfferAvailable(true);
            storeList.add(s);
        }
        return storeList;
    }
}
