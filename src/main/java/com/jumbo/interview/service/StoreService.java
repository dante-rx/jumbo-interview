package com.jumbo.interview.service;

import com.jumbo.interview.domain.Store;
import com.jumbo.interview.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Value("${stores.numberOfStoresToReturn}")
    private int numberOfStoresToReturn;

    public List<Store> getTopClosestStores(double latitude, double longitude) {
        return storeRepository.findTopClosestStoresByLatitudeAndLongitude(latitude,longitude, numberOfStoresToReturn);
    }
}
