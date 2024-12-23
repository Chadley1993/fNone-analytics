package com.measure_it.ocs.controllers;

import com.measure_it.ocs.services.DynamicSensorInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health")
    public String health() {
        return "Ok";
    }

    @GetMapping("/sensor-status")
    public String sensorHealth(@RequestParam String[] sensorNames) throws InterruptedException {
        for (String name : sensorNames) {
            if (DynamicSensorInfo.getInstance().containsKey(name)) {
                return "Name" + name + ": " + DynamicSensorInfo.getInstance().get(name).getHeader();
            }
        }
        return "No info";
    }
}

