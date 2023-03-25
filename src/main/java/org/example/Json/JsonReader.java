package org.example.Json;

import org.example.Entities.Client;
import org.example.Entities.Food;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для удобства парсинга json файлов
 */
public class JsonReader {
    private String path;

    public JsonReader(String path) {
        this.path = path;
    }

    /**
     * Метод, преобразующий json-файл в массив клиентов
     * @return массив посетителей
     */
    public Client[] parseClientsIntoArray() {
        Client[] clients = new Client[5];
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray json = (JSONArray) jsonParser.parse(new FileReader(path)); // тк внутри массив преобразуем к массиву
            int counter = 0;
            // проходка по всем элементам массива
            for (Object o : json) {
                JSONObject jsonObject = (JSONObject) o; // преобразуем к json-объекту для удобства
                String name = (String) jsonObject.get("name");
                int money = ((Long) jsonObject.get("money")).intValue();
                JSONArray orderJsonArray = (JSONArray) jsonObject.get("order");
                int[] order = new int[orderJsonArray.size()];
                // заполним массив id_заказа
                for (int i = 0; i < orderJsonArray.size(); i++) {
                    order[i] = ((Long) orderJsonArray.get(i)).intValue();
                }
                Client client = new Client(name, money, order);
                clients[counter++] = client;
            }
        } catch (ParseException | IOException e) {
            System.out.println("Что-то пошло не так при попытке распарсить json - clients.json");
        }
        return clients;
    }

    /**
     * Метод, заполняющий массив еды на основе данных json-файла
     * @param food массив еды
     * @param ids массив idшек в заказе клиента
     */
    public void parseFoodIntoArray(Food[] food, int[] ids) {
        JSONParser jsonParser = new JSONParser();
        try {
            int counter = 0;
            JSONArray json = (JSONArray) jsonParser.parse(new FileReader(path));
            for (Object o : json) {
                JSONObject jsonObject = (JSONObject) o;
                int id = ((Long) jsonObject.get("dish_id")).intValue();
                for (int i : ids) {
                    // если в заказе клиента есть текущее блюдо, то добавляем его
                    if (i == id) {
                        food[counter++] = new Food(id, (String) jsonObject.get("dish_name"), ((Long) jsonObject.get("dish_cost")).intValue(), ((Long) jsonObject.get("prep_time")).intValue());
                    }
                }
            }
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
