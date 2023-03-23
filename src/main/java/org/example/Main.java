package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Supervisor supervisor = new Supervisor();
        String[] names = new String[] {"Misha", "Semen", "Bagda", "Akta", "Karpov"};
        for (int i = 0; i < 5; ++i) {
            Client client = new Client(names[i]);
            executorService.submit(client);
            supervisor.addClient(client);
        }

        executorService.shutdown();
    }
}