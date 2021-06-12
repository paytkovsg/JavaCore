package Lesson7.Homework7.project;

import Lesson7.Homework7.project.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
