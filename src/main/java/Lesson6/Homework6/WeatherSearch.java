package Lesson6.Homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class WeatherSearch {
    //Объявляем переменные
    public static final String HOST = "dataservice.accuweather.com";
    public static final String FORECAST = "forecasts";
    public static final String API_VERSION = "v1";
    public static final String FORECAST_TYPE = "daily";
    public static final String FORECAST_PERIOD = "5day";

    public static final String LOCATION_KEY = "295212";
    public static final String API_KEY = "jynwb58MTqZESIGogbpxyvi0BcPtcEFT";



    public static void main(String[] args) throws IOException {

        // создаем OkHttp клиента
      OkHttpClient client = new OkHttpClient();

        // собираем URL из сегментов

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(LOCATION_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

//        System.out.println(url.toString());

        // создаем запрос

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        // получаем ответ на наш запрос и выводим в консоль
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }


}
