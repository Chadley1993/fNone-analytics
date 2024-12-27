package com.measure_it.ocs.controllers;

import com.measure_it.ocs.models.DataFrame;
import com.measure_it.ocs.models.RawSensorData;
import com.measure_it.ocs.services.DynamicSensorInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CentralServer {
    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/data-bridge")
    public void dataCapture(@RequestBody RawSensorData rawSensorData, @RequestHeader Map<String, String> headers) {
//        System.out.println(headers);
        String sensorName = headers.get("sensor-name");
//        System.out.println("Data from: " + sensorName);
//        System.out.println("Data: " + rawSensorData.toString());

        DataFrame<RawSensorData> dataFrame = new DataFrame<>(sensorName, rawSensorData);
        DynamicSensorInfo.getInstance().put(sensorName, dataFrame);
    }

    @PostMapping("/pitWall-bridge")
    public List<DataFrame<RawSensorData>> pitWallBridge(@RequestBody String[] sensorName) {
        List<DataFrame<RawSensorData>> data = new ArrayList<>();
        for (String name : sensorName) {
            if (DynamicSensorInfo.getInstance().containsKey(name))
                data.add(DynamicSensorInfo.getInstance().get(name));
        }
        return data;
    }

    @GetMapping("/onboard-bridge")
    public Double onboardDataEndpoint(@RequestParam String sensorName) {
        return DynamicSensorInfo.getInstance().get(sensorName).getData().getTemperatureCelsius();
    }

    @RequestMapping(value = "/pitWall-bridge", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handlePreflight() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
