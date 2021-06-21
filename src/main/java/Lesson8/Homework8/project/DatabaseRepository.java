package Lesson8.Homework8.project;

import java.io.IOException;
import java.sql.SQLException;

public interface DatabaseRepository {
    void getWeatherBase(Periods periods) throws IOException, SQLException;
}
