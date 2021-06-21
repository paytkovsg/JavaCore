package Lesson8.Homework8.project;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonRootName(value = "Temperature")
public  class Temperature {
    @JsonProperty(value = "Metric")
    private
    TemperatureUnit metric;

    @JsonProperty(value = "Imperial")
    private TemperatureUnit imperial;

    @JsonGetter("Metric")
    public TemperatureUnit getMetric() {
        return metric;
    }

    @JsonSetter("Metric")
    public void setMetric(TemperatureUnit metric) {
        this.metric = metric;
    }

    @JsonGetter("Imperial")
    public TemperatureUnit getImperial() {
        return imperial;
    }

    @JsonSetter("Imperial")
    public void setImperial(TemperatureUnit imperial) {
        this.imperial = imperial;
    }
}
