package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
   private Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        duplicates.computeIfAbsent(fileProperty, k -> new ArrayList<>()).add(file);
        return FileVisitResult.CONTINUE;
    }

    public void getDuplicates() {
        duplicates.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .peek(e -> System.out.println(e.getKey()))
                .flatMap(entry -> entry.getValue().stream())
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("."), visitor);
        visitor.getDuplicates();

    }
}