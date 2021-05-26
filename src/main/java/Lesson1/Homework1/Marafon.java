package Lesson1.Homework1;

public class Marafon {
    public static void main(String[] args) {
        //создаем массивы спортсменов и препятствий
        JumpRunnable[] members = {
                new Human("Коля", 5000, 2),
                new Cat("Барсик", 500, 1 ),
                new Robot("Робот", 10, 1),

        };

        Оbstaclable[] obstacles = {
                new Treadmill(350),
                new Wall(2),
        };

        /*цикл соревнований. начало счетчика первый спортсмен в массиве спортсменов, пробегает по массиву препятствий,
        выполняя методы, переопределенные в классе спортсмена
        и  если препятствия пройдены, то победа, если же хоть одно препятствие не пройдено, по выбывает из соревнований
         */

        for (int i = 0; i < members.length; i++) {
            JumpRunnable member = members[i];
            System.out.println("На полосу препятствий выходит " + member);
            boolean winner = true;
            for (int j = 0; j < obstacles.length; j++) {
                Оbstaclable obstacle = obstacles[j];
                System.out.println(member + " пробует пройти " + obstacle);
                if (obstacle.toJump(member.getMaxJump()) || obstacle.toRun(member.getMaxRun())){
                    System.out.println("И у него получается!");
                } else {
                    winner = false;
                    System.out.println("И у него не получается. " + member + " Выбывает из гонки");
                    break;
                }

            }
        }
    }

}
