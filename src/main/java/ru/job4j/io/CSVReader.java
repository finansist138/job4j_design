package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");
        String out = argsName.get("out");
        String[] filters = filter.split(",");

        try (var scanner = new Scanner(new FileReader(path))) {
            PrintStream output = "stdout".equals(out) ? System.out : new PrintStream(new FileOutputStream(out));

            String[] headers = scanner.nextLine().split(delimiter);

            List<Integer> filterIndexes = new ArrayList<>();
            for (String columName : filters) {
                for (int i = 0; i < headers.length; i++) {
                    if (columName.equals(headers[i])) {
                        filterIndexes.add(i);
                        break;
                    }
                }
            }
            StringJoiner headerJoiner = new StringJoiner(delimiter);
            for (int index : filterIndexes) {
                headerJoiner.add(headers[index]);
            }
            output.println(headerJoiner);
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(delimiter);
                StringJoiner rowJoiner = new StringJoiner(delimiter);
                for (int index : filterIndexes) {
                    rowJoiner.add(row[index]);
                }
                output.println(rowJoiner);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Должно быть 4 аргумента");
        }
        ArgsName argsName = ArgsName.of(args);
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");
        String out = argsName.get("out");
        String[] filters = filter.split(",");

        if (path.isBlank()) {
            throw new IllegalArgumentException("Файл не должен быть пустым");
        }
        if (!path.endsWith(".csv")) {
            throw new IllegalArgumentException("Файл должен иметь расширение .csv");
        }
        if (!delimiter.equals(";")) {
            throw new IllegalArgumentException("Разделитель должен быть ;");
        }
        if (out.isBlank()) {
            throw new IllegalArgumentException("Параметр out не должен быть пустым");
        }
        if (filters.length == 0) {
            throw new IllegalArgumentException("Фильтр должен содержать хотя бы один столбец");
        }
        handle(argsName);
    }
}