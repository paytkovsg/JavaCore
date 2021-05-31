package Lesson3.Homework3;

public class Box <T extends Fruit>  {

    private final T fruit; // обобщаем тип
    private int currentItemsCount = 0; // начальное количество фруктов

    //создаем конструктор коробки, принимает тип фруктов и начальное количество
    public Box(T fruit, int count) {
        this.fruit = fruit;
        currentItemsCount = count;
    }
    //метод добавления фруктов в коробку приращиваем начальное количество фруктов, количеством переданным в конструкторе
    public void addFruit (int count) {
        currentItemsCount += count;

    }
    //вычисляем вес коробок (берем вес фрукта и умножаем на количество)
    public float getWeight() {
        float weight = fruit.getFruitWeight();
        return weight * currentItemsCount;
    }

// Сравниваем вес коробок
    public boolean compare (Box<? extends Fruit> o) {
        if(this.getWeight() == o.getWeight()) {
            return true;
        } else {
            return false;
        }

    }

    // Пересыпание фруктов из одной коробки в другую
    public Box<T> filling(Box<T> srcBox) {
        currentItemsCount += srcBox.currentItemsCount;
        srcBox.currentItemsCount = 0;
        return this;
    }
}
