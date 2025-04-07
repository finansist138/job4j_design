package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validateParameters(args);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validateParameters(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Корневая папка пуста. Используйте ROOT_FOLDER.");
        }
        Path file = Paths.get(args[0]);
        if (!Files.exists(file)) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.toFile().getAbsolutePath()));
        }
        if (!Files.isDirectory(file)) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.toFile().getAbsolutePath()));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Расширение файла должно быть . ");
        }
    }
}