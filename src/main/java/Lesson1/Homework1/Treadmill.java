package Lesson1.Homework1;

public class Treadmill implements Оbstaclable {
    int length;

    public Treadmill(int length) {
        this.length = length;
    }
    @Override
    public boolean toRun(int maxLength) {
        return (maxLength >= length);
    }

    @Override
    public boolean toJump(int maxHeight) {
        return false;
    }

    @Override
    public String toString() {
        return "Беговую дорожку, длиной  " + length + " м";
    }
}
