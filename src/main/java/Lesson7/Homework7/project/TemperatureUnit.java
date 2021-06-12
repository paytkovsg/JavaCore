package Lesson7.Homework7.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Temperature")
public class TemperatureUnit {
    @JsonProperty("Value")
    private Float value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private Integer unitType;

    @JsonProperty("Value")
    public Float getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Float value) {
        this.value = value;
    }

    @JsonProperty("Unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("Unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("UnitType")
    public Integer getUnitType() {
        return unitType;
    }

    @JsonProperty("UnitType")
    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

}
