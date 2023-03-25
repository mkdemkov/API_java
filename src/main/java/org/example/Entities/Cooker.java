package org.example.Entities;

import org.example.Json.JsonReader;

public class Cooker {
    private boolean isBusy;
    private int[] order;

    public Cooker(boolean isBusy, int[] order) {
        this.isBusy = isBusy;
        this.order = order;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void addOrder(int[] order) {
        this.order = order;
    }

    public void startCooking(Client client) {
        int[] ids = client.getOrder();
        JsonReader jsonReader = new JsonReader("input/menu.json");
        Food[] food = new Food[ids.length];
        jsonReader.parseFoodIntoArray(food, ids);
        Order order = new Order(false, food);
        System.out.printf("Заказ для %s начал готовиться. Время готовки составит %s минут\n", client.getName(), order.getTime());
        isBusy = true;
        System.out.printf("Заказ для %s готов!\n", client.getName());
        isBusy = false;
    }
}
