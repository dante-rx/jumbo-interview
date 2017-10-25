package com.jumbo.interview.repository;

import com.jumbo.interview.domain.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> findTopClosestStoresByLatitudeAndLongitude(double latitude, double longitude, int numberOfStoresToReturn);
}
