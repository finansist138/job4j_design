package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkArgs(ArgsName args) {
        File directory = new File(args.get("d"));
        String exclude = args.get("e");
        String output = args.get("o");
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid source directory");
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Extension must start with the \".\" character");
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("Archive must have the extension \".zip\"");
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName arg = ArgsName.of(args);
        Zip.checkArgs(arg);
        File directory = new File(arg.get("d"));
        String exclude = arg.get("e");
        File target = new File(arg.get("o"));
        List<Path> sources = search(directory.toPath(), path -> path.toFile().getName().endsWith(exclude));
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        zip.packFiles(sources, target);
    }
}