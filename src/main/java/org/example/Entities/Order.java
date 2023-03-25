package org.example.Entities;

import java.util.Arrays;

/**
 * Класс, описывающий заказ посетителя
 */
public class Order {
    private int time; // время для готовки
    private boolean isReady;
    private Food[] foodAndDrink;

    public Order(boolean isReady, Food[] foodAndDrink) {
        this.isReady = isReady;
        this.foodAndDrink = foodAndDrink;
        time = 0;
    }

    @Override
    public String toString() {
        return String.format("Заказ - %s", Arrays.toString(foodAndDrink));
    }

    /**
     * Метод, возвращающий общее время готовки заказа
     * @return время готовки всего заказа
     */
    public int getTime() {
        for (Food food : foodAndDrink) {
            time += food.getTime();
        }
        return time;
    }
}
