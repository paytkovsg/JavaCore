package Lesson1.Homework1;

public class Robot implements JumpRunnable {
    private String name;
    private int maxRun;
    private int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public int getMaxJump(){
        return maxJump;

    }

    @Override
    public void jump(){
        System.out.println(name + "пыгнул на ");
    }

    @Override
    public int getMaxRun(){
        return maxRun;
    }

    @Override
    public void run(){
        System.out.println(name + "пробежал на ");
    }

    @Override
    public String toString() {
        return "Спортсмен " + name;
    }
}
