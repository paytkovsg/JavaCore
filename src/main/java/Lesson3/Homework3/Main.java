package Lesson3.Homework3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Задача 1. Метод, который меняет элементы массива местами

        String[] arr = {"1", "2", "3", "4"};
        System.out.println("Задача 1\n" + Arrays.toString(arr));
        swapElements(arr, 0, 3);
        System.out.println(Arrays.toString(arr));

        // Задание 2
        //Создаем коробки для фруктов и заполняем их соответствующими фруктами
        Box<Apple> appleBox = new Box<>(new Apple(), 3);
        Box<Apple> appleBox2 = new Box<>(new Apple(), 0);
        Box<Orange> orangeBox = new Box<>(new Orange(), 10);

        appleBox.addFruit(33); //сыпем в коробку c яблоками яблоки, а в коробку с апельсинами апельсины
        orangeBox.addFruit(15);

        System.out.println("Задача 2\n" + "Кробка с яблоками весит: " + appleBox.getWeight());
        System.out.println("Коробка с яблоками №2 весит: " + appleBox2.getWeight());
        System.out.println("Коробка с апельсинами весит: " + orangeBox.getWeight());

        //заполняем вторую коробку, пересыпав яблоки из первой
        appleBox2.filling(appleBox);

        System.out.println("Вес коробок после пересыпания: ");
        System.out.println("Кробка с яблоками весит: " + appleBox.getWeight());
        System.out.println("Коробка с яблоками №2 весит: " + appleBox2.getWeight());
        System.out.println("Коробка с апельсинами весит: " + orangeBox.getWeight());
        System.out.println("Сравниваем коробки:\n");
        if(appleBox2.compare(orangeBox)){
            System.out.println("Коробки одинаковые");
        } else {
            System.out.println("Коробки разные");
        }
    }

    private static <T> void swapElements(T[] arr, int i, int i1) {
        T temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }


}
