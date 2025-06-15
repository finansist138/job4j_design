package ru.job4j.serialization.json;

public class Driver {
    private final String name;
    private final String surname;

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + '}';
    }
}
