package org.example.Entities;

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

    @Override
    public String toString() {
        return String.format("id - %s", id);
    }
}
