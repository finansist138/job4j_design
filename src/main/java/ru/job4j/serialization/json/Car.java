package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final int vinCode;
    private final String model;
    private final boolean isAutoKpp;
    private final Driver driver;
    private final String[] serviceHistory;

    public Car(int vinCode, String model, boolean isAutoKpp, Driver driver, String[] serviceHistory) {
        this.vinCode = vinCode;
        this.model = model;
        this.isAutoKpp = isAutoKpp;
        this.driver = driver;
        this.serviceHistory = serviceHistory;
    }

    @Override
    public String toString() {
        return "Car{"
                + "vinCode=" + vinCode
                + ", model='" + model + '\''
                + ", isAutoKpp=" + isAutoKpp
                + ", driver=" + driver
                + ", serviceHistory=" + Arrays.toString(serviceHistory)
                + '}';
    }
}
