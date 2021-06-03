package Lesson5.Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) throws IOException {
        //создаем заголовки и данные
        String [] headers = {"Value1", "Value2", "Value3"};
        int [][] data = {{100, 200, 300}, {400, 500, 600}};

        //создаем разделитель столбцов
        String separ = ";";
        // Экземпляр класса
        AppData appData = new AppData(headers, data);
        writeFile (appData, separ);
        readFile();

    }
    //метод записи в файл
    public static void writeFile(AppData appData, String separ) throws IOException {
        try (PrintWriter pw = new PrintWriter("./output.csv")) {
            for(String s : appData.getHeaders()){
                pw.print(s + separ);
            }
            pw.println();

            int [][] data = appData.getData();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    pw.print(data[i][j] + separ );
                }
                pw.write("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // метод чтения из файла. Файл читается целиком
    public static void readFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("./output.csv"))) {
            String s = null;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
