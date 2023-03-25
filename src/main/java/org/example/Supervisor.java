package org.example;

import java.util.ArrayList;

public class Supervisor {
    private static ArrayList<Client> clients;

    public Supervisor() {
        clients = new ArrayList<>();
    }

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static void process(Client client) {
        
    }
}
