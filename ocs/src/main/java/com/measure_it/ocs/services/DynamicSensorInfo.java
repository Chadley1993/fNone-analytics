package com.measure_it.ocs.services;

import com.measure_it.ocs.models.DataFrame;
import com.measure_it.ocs.models.RawSensorData;

import java.util.concurrent.ConcurrentHashMap;

public class DynamicSensorInfo {
    private static final DynamicSensorInfo INSTANCE = new DynamicSensorInfo();

    private final ConcurrentHashMap<String, DataFrame<RawSensorData>> map;

    private DynamicSensorInfo() {
        this.map = new ConcurrentHashMap<>();
    }

    public static DynamicSensorInfo getInstance() {
        return INSTANCE;
    }

    public void put(String key, DataFrame<RawSensorData> value) {
        map.put(key, value);
    }

    public DataFrame<RawSensorData> get(String key) {
        return map.get(key);
    }

    public DataFrame<RawSensorData> remove(String key) {
        return map.remove(key);
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }
}
