package Lesson2.Homework2;

public class Main {
    public static void main(String[] args) {
        try {
            arraySize(new String[][]{
                    {"1", "2", "3", "4"},
                    {"13", "21", "33", "41"},
                    {"7", "5", "23", "34"},
                    {"7", "9", "6", "8"}
            });
            arraySize(new String[][]{
                    {"1", "2", "3", "4"},
                    {"13", "21", "33", "41"},
                    {"7", "5", "23", "34"}
            });
            arraySize(new String[][]{
                    {"1", "str", "3", "4"},
                    {"13", "21", "str", "41"},
                    {"7", "5", "23", "34"},
                    {"7", "str", "6", "8"}
            });
        } catch (MySizeArrayException e) {
            System.out.println("Не верный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println("Не верный формат данных. Номер строки " + e.x + ", номер колонки " + e.y);
        }

    }

    public static void arraySize(String[][] array) throws MySizeArrayException, MyArrayDataException {
        int x = array.length;
        int y = array[0].length;
        System.out.println("Передан массив, размером: " + x + " * " + y);
        if (x != 4 || y != 4) {
            throw new MySizeArrayException(x, y);
        }

            int sum = 0;

            for(int i = 0; i < x; ++i) {
                for(int j = 0; j < y; ++j) {
                    try {
                        int num = Integer.parseInt(array[i][j]);
                        sum += num;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }

            System.out.println("sum = " + sum);


    }

}
