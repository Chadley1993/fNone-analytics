package com.measure_it.ocs.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.lang.reflect.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RawSensorData {
    private Double longitude;
    private Double latitude;
    private Double temperatureCelsius;
    private Double velocityKPH;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName()).append(" {");

        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            try {
                result.append(field.getName())
                        .append("=")
                        .append(field.get(this))
                        .append(", ");
            } catch (IllegalAccessException e) {
                result.append(field.getName()).append("=ACCESS_DENIED, ");
            }
        }

        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }

        result.append("}");
        return result.toString();
    }
}
