package com.example.motoinventoryservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name="vin-lookup")
public interface VinLookup {

    @GetMapping("/vehicle")
    public Map getVehicle();
}
