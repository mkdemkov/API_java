package org.example;


import org.example.Entities.Client;
import org.example.Entities.Cooker;
import org.example.Entities.Supervisor;
import org.example.Json.JsonReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5); // создаем 5 поток, каждому из которых назначается новый соккет
        String pathToClients = "input/clients.json"; // путь до json с клиентами кафе
        JsonReader jsonReader = new JsonReader(pathToClients);
        Supervisor supervisor = new Supervisor();
        Client[] clients = jsonReader.parseClientsIntoArray();
        Cooker[] cookers = new Cooker[]{new Cooker(false, null), new Cooker(false, null), new Cooker(false, null)};
        supervisor.addCookers(cookers);
        for (int i = 0; i < 5; ++i) {
            executorService.submit(clients[i]);
        }
        executorService.shutdown();
    }
}