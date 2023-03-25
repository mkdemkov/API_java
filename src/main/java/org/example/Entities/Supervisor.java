package org.example.Entities;

import org.example.Entities.Client;

import java.util.ArrayList;

/**
 * Суперкласс, связывающий все остальные сущности
 */
public class Supervisor {
    private static ArrayList<Client> clients;

    private static Cooker[] cookers;

    public Supervisor() {
        clients = new ArrayList<>();
    }

    /**
     * Метод, добавляющий очередного клиента в общий список
     * @param client клиент для добавления в очередь
     */
    public static void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Метод, добавляющий поваров на кухню
     * @param cookers повара, которых нужно добавить на кухню
     */
    public void addCookers(Cooker[] cookers) {
        Supervisor.cookers = cookers;
    }

    /**
     * Метод, назначающий свободному повару заказ
     * @param client клиент для обслуживания
     */
    public static void process(Client client) {
        boolean flag = false;
        try {
            for (Cooker cooker : cookers) {
                if (!cooker.isBusy() && !flag) {
                    cooker.startCooking(client);
                    flag = true;
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так");
        }
    }
}
