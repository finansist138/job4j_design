package ru.job4j.question;

import java.util.HashSet;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Set<User> supUser = new HashSet<>(previous);
        supUser.addAll(current);
        Set<Integer> idUser = new HashSet<>();
        for (User user : supUser) {
            idUser.add(user.getId());
        }

        int changed = supUser.size() - idUser.size();
        int added = idUser.size() - previous.size();
        int deleted = idUser.size() - current.size();

        return new Info(added, changed, deleted);
    }
}