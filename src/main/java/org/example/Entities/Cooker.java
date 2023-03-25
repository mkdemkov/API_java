package org.example.Entities;

import org.example.Json.JsonReader;

/**
 * Класс, описывающий повара
 */
public class Cooker {
    private boolean isBusy;
    private int[] order;

    public Cooker(boolean isBusy, int[] order) {
        this.isBusy = isBusy;
        this.order = order;
    }

    /**
     * Свойство, возаращающее статус занятности повара
     * @return занятость
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Метод, который отвечает за готовку блюда указанному клиенту
     * @param client посетитель, которому готовить
     * @throws InterruptedException
     */
    public void startCooking(Client client) throws InterruptedException {
        int[] ids = client.getOrder();
        JsonReader jsonReader = new JsonReader("input/menu.json");
        Food[] food = new Food[ids.length];
        jsonReader.parseFoodIntoArray(food, ids);
        Order order = new Order(false, food);
        System.out.printf("Заказ для %s начал готовиться. Время готовки составит %s минут\n", client.getName(), order.getTime());
        isBusy = true;
        Thread.sleep(order.getTime() * 100L); // имитируем готовку блюда
        System.out.printf("Заказ для %s готов!\n", client.getName());
        isBusy = false;
    }
}
