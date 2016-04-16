package com.retinio.api;

import com.retinio.pojo.Deal;
import com.retinio.pojo.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by championswimmer on 6/4/16.
 */
public class RetinioDataApi {

    public static List<Store> getStores() {
        List<Store> storeList = new ArrayList<>(10);
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

    public static List<Deal> getDeals() {
        List<Deal> dealList = new ArrayList<>(3);


        Deal deal = new Deal();
        deal.setName("50% OFF on Sunglasses");
        deal.setDesc("Get 50% off on new purchases");
        deal.setStoreName("EagleEye, Pitampura");
        deal.setDealType(Deal.DealTypes.EYEWEAR);
        dealList.add(deal);


        deal = new Deal();
        deal.setName("30% OFF on Checkup");
        deal.setDesc("On you second eye checkup get 30% off");
        deal.setStoreName("Eye Point, Vikaspuri");
        deal.setDealType(Deal.DealTypes.CHECKUP);
        dealList.add(deal);


        deal = new Deal();
        deal.setName("1+1 on Aviators");
        deal.setDesc("Select Aviators have buy one, get one free");
        deal.setStoreName("TitanEYE+, Rajouri Garden");
        deal.setDealType(Deal.DealTypes.EYEWEAR);
        dealList.add(deal);

        return dealList;
    }
}
