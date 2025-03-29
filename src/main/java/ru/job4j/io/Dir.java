package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {

        File file = new File("/Users/artem/IdeaProjects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Директория не существует: %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не директория: %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("Размер директории: %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getAbsoluteFile());
        }
        String[] files = file.list();
            for (String name : files) {
                System.out.println(String.format("Имя файла: %s", name + "; "
                        + "Размер: " + file.length()));
            }
    }
}
