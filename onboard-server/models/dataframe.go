package models

import "time"

type Dataframe struct {
	SensorName string    `json:"sensorName" binding:"required"`
	Timestamp  time.Time `json:"timestamp,omitempty"`

	SpeedKPH    string `json:"speedKPH,omitempty"`
	Latitude    string `json:"latitude,omitempty"`
	Longitude   string `json:"longitude,omitempty"`
	Temperature string `json:"temperature,omitempty"`
}
