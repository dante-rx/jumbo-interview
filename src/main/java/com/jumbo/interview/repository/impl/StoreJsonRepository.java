package com.jumbo.interview.repository.impl;

import com.jumbo.interview.domain.Store;
import com.jumbo.interview.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreJsonRepository implements StoreRepository{
    private final Set<Store> stores;

    public StoreJsonRepository(Set<Store> stores) {
        this.stores = stores;
    }

    @Override
    public List<Store> findTopClosestStoresByLatitudeAndLongitude(double latitude, double longitude, int numberOfStoresToReturn) {
        return stores.stream()
                .sorted(Comparator.comparingDouble(o -> calculateDistance(o, latitude, longitude)))
                .limit(numberOfStoresToReturn)
                .collect(Collectors.toList());
    }

    private double calculateDistance(Store store, double latitude, double longitude) {
        return Math.hypot(Double.valueOf(store.getLatitude()) - latitude, Double.valueOf(store.getLongitude()) - longitude);
    }
}
