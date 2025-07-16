package ru.job4j.serialization.json;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "driver")
public class Driver {
    @XmlAttribute
    private String name;
    private String surname;

    public Driver() {
    }

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
