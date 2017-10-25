package com.jumbo.interview.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class StoresWrapper {
    private Set<Store> stores;

    public Set<Store> getStores() {
        return Optional.of(stores).orElse(new HashSet<>());
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
