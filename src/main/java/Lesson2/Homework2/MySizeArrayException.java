package Lesson2.Homework2;

public class MySizeArrayException extends Exception {
    public int x;
    public int y;

    public MySizeArrayException(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
