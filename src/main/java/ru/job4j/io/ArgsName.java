package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key must not be null or empty.");
        }
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String arg : args) {
            if (arg == null || !arg.startsWith("-")) {
                throw new IllegalArgumentException("Error: This argument " + arg + " does not start with a '-' character");
            }
            if (!arg.contains("=")) {
                throw new IllegalArgumentException("Error: This argument " + arg + " does not contain an equal sign");
            }
            String[] parts = arg.substring(1).split("=", 2);
            if (parts.length != 2 || parts[0].isEmpty()) {
                throw new IllegalArgumentException("Error: This argument " + arg + " does not contain a key");
            }
            if (parts[1].isEmpty()) {
                throw new IllegalArgumentException("Error: This argument " + arg + " does not contain a value");
            }
            values.put(parts[0], parts[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}