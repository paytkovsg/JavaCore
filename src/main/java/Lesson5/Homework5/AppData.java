package Lesson5.Homework5;

import java.io.Serializable;
import java.util.Arrays;

public class AppData  {
//создаем поля, конструктор, геттеры и сеттеры, переопределяем toString
    private String[] headers;
    private int [][] data;

    public AppData(String[] headers, int[][] data) {
        this.headers = headers;
        this.data = data;
    }

    public String[] getHeaders() {
        return headers;
    }

    public int[][] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "headers=" + Arrays.toString(headers) +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}


