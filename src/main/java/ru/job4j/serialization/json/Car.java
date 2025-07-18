package ru.job4j.serialization.json;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import org.json.JSONObject;

import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private int vinCode;
    private String model;

    @XmlAttribute
    private boolean isAutoKpp;
    private Driver driver;

    private String[] serviceHistory;

    public Car() {
    }

    public Car(int vinCode, String model, boolean isAutoKpp, Driver driver, String[] serviceHistory) {
        this.vinCode = vinCode;
        this.model = model;
        this.isAutoKpp = isAutoKpp;
        this.driver = driver;
        this.serviceHistory = serviceHistory;
    }

    public int getVinCode() {
        return vinCode;
    }

    public String getModel() {
        return model;
    }

    public boolean isAutoKpp() {
        return isAutoKpp;
    }

    public String[] getServiceHistory() {
        return serviceHistory;
    }

    public Driver getDriver() {
        return driver;
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

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car(123456789, "Toyota Camry", true, new Driver("Artem", "Ivanov"),
                new String[] {"12.02.2024 - oil change", "10.06.2025 - bumper painting"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vinCode", car.getVinCode());
        jsonObject.put("model", car.getModel());
        jsonObject.put("isAutoKpp", car.isAutoKpp());
        jsonObject.put("driver", car.getDriver());
        jsonObject.put("serviceHistory", car.getServiceHistory());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(car).toString());
    }
}
