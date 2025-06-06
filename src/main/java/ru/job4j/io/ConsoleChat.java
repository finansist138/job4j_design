package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private boolean isActive = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> phrases = readPhrases();
        String greeting = "Добро пожаловать в чат! Для выхода из приложения, напишите 'закончить', "
                + "если хотите, чтобы чат-бот замолчал, напишите 'стоп', для продолжение общения с чат-ботом, "
                + "напишите 'продолжить'";
        String stop = "Чат приостановлен. Напишите 'продолжить' для возобновления.";
        String continueChat = "Чат возобновлен.";
        String bue = "Программа завершена";
        if (phrases.isEmpty()) {
            throw new IllegalArgumentException("Пустое хранилище фраз");
        }
        Scanner scanner = new Scanner(System.in, Charset.defaultCharset());
        System.out.println(greeting);
        String userInput = "";
        Random random = new Random();
        while (!OUT.equals(userInput)) {
                userInput = scanner.nextLine();
                log.add("Вы: " + userInput);
                if (STOP.equals(userInput)) {
                    isActive = false;
                    log.add(stop);
                    System.out.println(stop);
                } else if (CONTINUE.equals(userInput)) {
                    isActive = true;
                    log.add(continueChat);
                    System.out.println(continueChat);
                }
                if (isActive) {
                    String phrase = phrases.get(random.nextInt(phrases.size()));
                    System.out.println("Бот: " + phrase);
                    log.add("Бот: " + phrase);
                }
        }
        System.out.println(bue);
        log.add(bue);
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            reader.lines()
                    .forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chat.txt", "data/answer.txt");
        consoleChat.run();
    }
}
