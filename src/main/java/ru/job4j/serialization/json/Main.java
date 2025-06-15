package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        final Car car = new Car(123456789, "Toyota Camry", true, new Driver("Artem", "Ivanov"),
                 new String[] {"12.02.2024 - oil change", "10.06.2025 - bumper painting"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"vinCode\":\"123456789\","
                        + "\"model\":\"Toyota Camry\","
                        + "\"isAutoKpp\":true,"
                        + "\"driver\":"
                        + "{"
                        + "\"name\":\"Artem\","
                        + "\"surname\":\"Ivanov\""
                        + "},"
                        + "\"serviceHistory\":"
                        + "[\"12.02.2024 - oil change\",\"10.06.2025 - bumper painting\",\"15.06.2025 - balancing\"]"
                        + "}";

        final Car carFromJson = gson.fromJson(carJson, Car.class);
        System.out.println(carFromJson);
    }
}
