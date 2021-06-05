package Lesson4.Homework4;

import java.util.*;

public class Phonebook {
    // Объявляем Мапу и создаем конструктор
    private HashMap<String, HashSet<Integer>> phoneBook1;
    Phonebook() {
        this.phoneBook1 = new HashMap<>();
    }

    //Метод добавляет контакты в справочник
    void add(String surname, int number) {
        HashSet<Integer> phoneBook = phoneBook1.getOrDefault(surname, new HashSet<>());
        phoneBook.add(number);
        phoneBook1.put(surname, phoneBook);
    }

    // Метод ищет номер телефона по фамилии. getOrDefault возвращает все значения подаваемого в метод ключа
    void get(String surname) {

        System.out.printf("%nКонтакт "+surname+": "+ phoneBook1.getOrDefault(surname, new HashSet<>()));
    }
}
