package Lesson8.Homework8.project;

import com.fasterxml.jackson.annotation.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    //определяем поля, которые необходимо вывести в консоль, остальные игнорируем
    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("Temperature")
    private Temperature temperature; // т.к. вложенный массив, чтоб не плодить вложенные классы, выведем в отдельные классы

    @JsonProperty("LocalObservationDateTime")
    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    @JsonProperty("LocalObservationDateTime")
    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return weatherText;
    }

    @JsonProperty("WeatherText")
    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Погода: " + '\n' +
                "На дату: " + localObservationDateTime + '\n' +
                "Ожидается: " + weatherText + '\n' +
                "Температура: " + temperature.getMetric().getValue() + " " + temperature.getMetric().getUnit() +
                ' ';

    }
}





