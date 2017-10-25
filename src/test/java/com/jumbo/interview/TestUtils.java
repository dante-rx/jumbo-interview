package com.jumbo.interview;

import com.jumbo.interview.domain.Store;

import java.util.ArrayList;
import java.util.List;

public abstract class TestUtils {
    public static List<Store> prepareStoreList(int numberOfStore){
        List<Store> storeList = new ArrayList<>();
        for(int i=1;i<=numberOfStore;i++){
            Store store = new Store();

            store.setLatitude(String.valueOf(i));
            store.setLongitude(String.valueOf(i+1));

            storeList.add(store);
        }
        return storeList;
    }

    public static Store buildStore(double latitude, double longitude){
        Store store = new Store();
        store.setLatitude(String.valueOf(latitude));
        store.setLongitude(String.valueOf(longitude));
        return store;
    }
}
