package com.measure_it.ocs.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DataFrame<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Header header;
    T data;

    public DataFrame(String sensorName, T data) {
        this.header = new Header(sensorName, LocalDateTime.now());
        this.data = data;
    }
}

@Data
class Header implements Serializable {
    private static final long serialVersionUID = 1L;

    String sensorName;
    LocalDateTime timeStamp;

    public Header(String sensorName, LocalDateTime now) {
        this.sensorName = sensorName;
        this.timeStamp = now;
    }

    public String toString() {
        return String.format("Name= %s, LastUpdate=%s", this.sensorName, this.timeStamp.toString());
    }
}

