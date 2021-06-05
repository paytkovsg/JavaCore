package Lesson4.Homework4;

import java.util.HashMap;
import java.util.Map;

public class MainBook {
    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        phoneBook.add ("Иванов", 1234567);
        phoneBook.add("Петров", 7895642);
        phoneBook.add("Сидорова", 85621884);
        phoneBook.add("Васечкин", 62485178);
        phoneBook.add("Иванова", 54218542);
        phoneBook.add("Петрова", 385105885);
        phoneBook.add("Сидорова", 2822584);
        phoneBook.add("Иванов", 258522585);


        phoneBook.get("Сидорова");
    }

}
