package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String line;
            String rslt = null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                if (rslt == null && ("400".equals(split[0]) || "500".equals(split[0]))) {
                    rslt = split[1];
                } else if (rslt != null && ("200".equals(split[0]) || "300".equals(split[0]))) {
                    writer.write(rslt + ";" + split[1] + System.lineSeparator());
                    rslt = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}