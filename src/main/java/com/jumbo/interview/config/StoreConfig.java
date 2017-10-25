package com.jumbo.interview.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.interview.domain.Store;
import com.jumbo.interview.domain.StoresWrapper;
import com.jumbo.interview.repository.StoreRepository;
import com.jumbo.interview.repository.impl.StoreJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Configuration
public class StoreConfig {
    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:stores.json")
    private Resource storesJsonFile;

    @Bean
    public Set<Store> stores() throws IOException {
        return Optional.of(objectMapper.readValue(storesJsonFile.getFile(), StoresWrapper.class))
                .orElse(new StoresWrapper())
            .getStores();
    }

    @Bean
    public StoreRepository storeRepository() throws IOException {
        return new StoreJsonRepository(stores());
    }
}
