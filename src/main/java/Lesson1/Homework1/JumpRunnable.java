package Lesson1.Homework1;
//создаем интерфейс действий спортсменов
public interface JumpRunnable {
    int getMaxJump(); // инициализируем максимальную высоту прыжка
    void jump(); //определяем метод прыжка

    int getMaxRun(); //инициализируем максимальную длину бега
    void run(); // отпределяем метод бега

}
