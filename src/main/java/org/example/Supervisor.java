package org.example;

import java.util.List;

public class Supervisor {
    private List<Client> clients;

    public void addClient(Client client) {
        clients.add(client);
    }

    public static void process(Client client) {

    }
}
