package Lesson8.Homework8.project;

import java.io.IOException;
import java.sql.*;

public class DatabaseRepositorySQLite implements DatabaseRepository {

String filename = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Создаем базу
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "city TEXT NOT NULL," +
            "date_time TEXT NOT NULL," +
            "weather_text TEXT NOT NULL," +
            "temperature REAL NOT NULL" +
            ");";

    //Запрос на добавление данных в базу
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?);";
    String selectAllquerry = "SELECT * FROM weather;";


    public DatabaseRepositorySQLite(){
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    // Соединяемся с базой данных.
    Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        connection.setAutoCommit(true);
        return connection;
    }



    // Создаем таблицу, если есть необходимость.
    void createTableIfNotExists() throws SQLException {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    void saveWeatherData(String city, String dateTime, String wText, Double temperature) throws SQLException {

        try( Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery);) {
            saveWeather.setString(1, city);
            saveWeather.setString(2, dateTime);
            saveWeather.setString(3, wText);
            saveWeather.setDouble(4, temperature);
            saveWeather.execute();
            saveWeather.closeOnCompletion();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Читаем данные из базы в консоль
    void selectAll() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(selectAllquerry);
            System.out.println("N | Город | Время | Погода | Температура");
            while ( resultSet.next())
            {
                System.out.println(
                        resultSet.getInt(1) +
                                " | " + resultSet.getString(2) +
                                " | "+ resultSet.getString(3)+
                                " | " + resultSet.getString(4) +
                                " | " + resultSet.getDouble(5)
                );
            }

            statement.closeOnCompletion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void getWeatherBase(Periods periods) throws IOException {

    }
}
