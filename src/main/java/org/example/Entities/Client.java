package org.example.Entities;

import java.util.Arrays;

/**
 * Класс, описывающий посетителя ресторона
 */
public class Client implements Runnable {

    private String name;
    private int money;
    private int[] order;

    public Client(String name, int money, int[] order) {
        this.name = name;
        this.money = money;
        this.order = order;
    }

    /**
     * Переопределение toString для удобства вывода в консоль
     * @return строка для вывода
     */
    @Override
    public String toString() {
        return String.format("Имя - %s, деньги - %d, заказ - %s", name, money, Arrays.toString(order));
    }

    /**
     * Свойство, просто возвращающее заказ клиента
     * @return массив idшников
     */
    public int[] getOrder() {
        return order;
    }

    /**
     * Свойство, возвращающее имя клиента
     * @return имя клиента
     */
    public String getName() {
        return name;
    }

    /**
     * Необходимый для работы соккета метод
     */
    public void run() {
        Supervisor.addClient(this); // вызов функции управляющей сущности
        Supervisor.process(this);
    }
}
