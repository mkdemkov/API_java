package org.example.Entities;

/**
 * Класс, описывающий блюдо из меню
 */
public class Food {
    private int id;
    private String name;
    private int cost;
    private int time;

    public Food(int id, String name, int cost, int time) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.time = time;
    }

    /**
     * Свойство, возвращающее время готовки определенного блюда
     * @return время готовки
     */
    public int getTime() {
        return time;
    }
}
