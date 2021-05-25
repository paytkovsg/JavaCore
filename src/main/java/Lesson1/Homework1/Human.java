package Lesson1.Homework1;
 /*Создаем класс участника соревнований, имплементируем интерфейс прыжка и бега,  задаем максимальные возможности
 участников и переопределяем методы интерфейса (также для кота и робота)
 */
public class Human implements JumpRunnable {
    private String name;
    private int maxRun;
    private int maxJump;
//???????????
    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;

    }
     /* максимальная высота прыжка, определенная в интерфейсе,
     переопределяется в максимальную высоты, определенную в спортсмене
     */
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
    public String toString(){
        return "Спортсмен " + name;
    }


}
