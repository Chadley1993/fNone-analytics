package com.measure_it.ocs.controllers;

import com.measure_it.ocs.models.DataFrame;
import com.measure_it.ocs.models.RawSensorData;
import com.measure_it.ocs.services.DynamicSensorInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CentralServer {
    @PostMapping("/data-bridge")
    public void dataCapture(@RequestBody RawSensorData rawSensorData, @RequestHeader Map<String, String> headers) {
//        System.out.println(headers);
        String sensorName = headers.get("sensor-name");
//        System.out.println("Data from: " + sensorName);
//        System.out.println("Data: " + rawSensorData.toString());

        DataFrame<RawSensorData> dataFrame = new DataFrame<>(sensorName, rawSensorData);
        DynamicSensorInfo.getInstance().put(sensorName, dataFrame);
    }

    @GetMapping("/data-bridge")
    public Double dataCapture(@RequestParam String sensorName) {
        return DynamicSensorInfo.getInstance().get(sensorName).getData().getTemperatureCelsius();
    }
}
