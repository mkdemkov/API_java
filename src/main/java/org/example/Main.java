package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Supervisor supervisor = new Supervisor();
        String pathToClients = "input/clients.json"; // путь до json с клиентами кафе
        JsonReader jsonReader = new JsonReader(pathToClients);
        Client[] clients = jsonReader.parseClientsIntoArray();
        for (int i = 0; i < 5; ++i) {
            Client client = clients[i];
            executorService.submit(client);
            supervisor.addClient(client);
        }

        executorService.shutdown();
    }
}