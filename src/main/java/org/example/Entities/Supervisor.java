package org.example.Entities;

import org.example.Entities.Client;

import java.util.ArrayList;

public class Supervisor {
    private static ArrayList<Client> clients;

    private static Cooker[] cookers;

    public Supervisor() {
        clients = new ArrayList<>();
    }

    public static void addClient(Client client) {
        clients.add(client);
    }

    public void addCookers(Cooker[] cookers) {
        Supervisor.cookers = cookers;
    }

    public static void process(Client client) {
        for (Cooker cooker : cookers) {
            if (!cooker.isBusy()) {
                cooker.startCooking(client);
            }
        }
    }
}
