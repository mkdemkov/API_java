package org.example;

public class Client implements Runnable {

    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void run() {
        Supervisor.process(this); // вызов функции управляющей сущности
    }
}
