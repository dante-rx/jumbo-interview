package com.jumbo.interview.controller;

import com.jumbo.interview.domain.Store;
import com.jumbo.interview.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @ApiOperation("Gets the top 5 closest interview with given longitude and latitude")
    @GetMapping("/closest")
    public List<Store> getClosestStores(@ApiParam(required = true) @RequestParam double latitude, @ApiParam(required = true) @RequestParam double longitude) {
        /*
            We could return the list of DTO objects instead but I don't know which fields are required
         */
        return storeService.getTopClosestStores(latitude,longitude);
    }
}
