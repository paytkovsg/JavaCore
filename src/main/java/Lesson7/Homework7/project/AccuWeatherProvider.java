package Lesson7.Homework7.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import Lesson7.Homework7.project.enums.Periods;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final String SEGMENT_DAY = "daily";
    private static final String SEGMENT_5DAYS = "5day";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        // Т.к. стоит выбор 1 день или 5, заворачиваем в switch
        switch (periods) {
            case NOW:
                HttpUrl url = new HttpUrl.Builder().scheme("http")
                        .host(BASE_HOST)
                        .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .build();
                Request request = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();

                String jsonResponse = response.body().string();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                //Десериализуем ответ и выводим в консоль
                List<WeatherResponse> weatherResponses = objectMapper.readValue(jsonResponse, new TypeReference<List<WeatherResponse>>() {
                });
                System.out.println(weatherResponses.toString());
                System.exit(0); // корректное завершение работы

                // На пять дней создаем новый билдер
            case FIVE_DAYS:
                HttpUrl urlFive = new HttpUrl.Builder().scheme("http")
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment(SEGMENT_DAY)
                        .addPathSegment(SEGMENT_5DAYS)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .build();
                Request requestFive = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(urlFive)
                        .build();
                Response responseFive = client.newCall(requestFive).execute();


                String jsonResponseFive = responseFive.body().string();
                // создаем цикл, т.к. нужно прочесть за 5 дней
                for (int i = 0; i < 5; i++) {
                    System.out.println("День " + (i+1));
                    // читаем без десериализации определенные поля, иначе нужно создавать дополнительные классы
                    if (objectMapper.readTree(jsonResponseFive).size() > 0) {
                        String dateTime = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Date").asText();
                        String tempMin = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asText();
                        String tempMax = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asText();
                        String tempUnit = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Unit").asText();
                        String dateDay = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Day/IconPhrase").asText();
                        String dateNight = objectMapper.readTree(jsonResponseFive).at("/DailyForecasts").get(i).at("/Night/IconPhrase").asText();

                        System.out.println("Погода на дату: " + dateTime + "\n" + "Ожидается: " + "Днем - " + dateDay +
                                ", Ночью - " + dateNight + "\n" + "Температура: " + tempMin + " - " + tempMax +
                                " (" + tempUnit + ")" );
                    }

                }
                System.exit(0); // выход


                // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
                //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
                //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
        }

    }

        public String detectCityKey () throws IOException {
            String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

            HttpUrl detectLocationURL = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment("locations")
                    .addPathSegment(API_VERSION)
                    .addPathSegment("cities")
                    .addPathSegment("autocomplete")
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("q", selectedCity)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(detectLocationURL)
                    .build();

            Response response = client.newCall(request).execute();


            if (!response.isSuccessful()) {
                throw new IOException("Невозможно прочесть информацию о городе. " +
                        "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
            }
            String jsonResponse = response.body().string();
            System.out.println("Произвожу поиск города " + selectedCity);

            if (objectMapper.readTree(jsonResponse).size() > 0) {
                String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
                System.out.println("Найден город " + cityName + " в стране " + countryName);
            } else throw new IOException("Город не найден");

            return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
        }
    }


