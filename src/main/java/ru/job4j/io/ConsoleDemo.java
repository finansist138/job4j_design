package ru.job4j.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleDemo {
    public static void main(String[] args) throws Exception {
        Console console = System.console();
        if (console == null) {
            System.out.println("Консоль недоступна");
            return;
        }
        String login = console.readLine("%s", "Введите логин: ");
        console.printf("Ваш логин: %s\n", login);
        char[] password = console.readPassword("%s", "Введите пароль: ");
        console.printf("Ваш пароль: " + String.valueOf(password));
        Arrays.fill(password, ' ');
    }
}