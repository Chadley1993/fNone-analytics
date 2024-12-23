package com.measure_it.ocs.controllers;

import com.measure_it.ocs.models.DataFrame;
import com.measure_it.ocs.models.RawSensorData;
import com.measure_it.ocs.services.DynamicSensorInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/pitWall-bridge")
    public List<DataFrame<RawSensorData>> pitWallBridge(@RequestParam String sensorName) {
        List<DataFrame<RawSensorData>> data = new ArrayList<>();
        data.add(DynamicSensorInfo.getInstance().get(sensorName));
        return data;
    }

    @GetMapping("/onboard-bridge")
    public Double onboardDataEndpoint(@RequestParam String sensorName) {
        return DynamicSensorInfo.getInstance().get(sensorName).getData().getTemperatureCelsius();
    }
}
