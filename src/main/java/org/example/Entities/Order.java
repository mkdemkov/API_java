package org.example.Entities;

import java.util.Arrays;

public class Order {
    private int time; // время для готовки
    private boolean isReady;
    private Food[] foodAndDrink;

    public Order(boolean isReady, Food[] foodAndDrink) {
        this.isReady = isReady;
        this.foodAndDrink = foodAndDrink;
    }

    @Override
    public String toString() {
        return String.format("Заказ - %s", Arrays.toString(foodAndDrink));
    }

    public int getTime() {
        return time;
    }
}
