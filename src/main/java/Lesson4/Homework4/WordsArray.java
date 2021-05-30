package Lesson4.Homework4;

import java.util.*;

public class WordsArray {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
                "стол", "дерево", "стул", "телефон", "стол",
                "стул", "ручка", "монитор", "диван", "ручка",
                "ручка", "самолет", "диван", "диван", "собака",
                "собака", "ручка", "монитор", "диван" ));// создаем строковый массив и записываем в него элементы


        System.out.println("Начальный массив\n arr = " + arr);

        //создаем коллекцию, имеющую только уникальные эелементы. На вход подаем наш массив
        Set<String> setArr = new LinkedHashSet<>(arr);
        System.out.println("Уникальные элементы массива:\n arr = " + setArr);
        System.out.println("Количество повторений элементов массива:");

         /*
         Ищем количество повторений элементов в массиве. Для этого считаем количество уникальных ключей элементов массива
          и ,используя метод frequency(), считаем количество повторений ключей в начальном массиве
          */
        for (String key : setArr) {
            System.out.println( key + ": " + Collections.frequency(arr, key));
        }


    }
}
