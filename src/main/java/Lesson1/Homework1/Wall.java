package Lesson1.Homework1;

public class Wall implements Оbstaclable {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean toRun(int maxLength) {
        return false;
    }

    @Override
    public boolean toJump(int maxHeight) {
        return (maxHeight >= height);
    }

    @Override
    public String toString() {
        return "Стену, высотой " + height + " м";
    }
}
