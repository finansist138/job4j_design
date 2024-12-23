package ru.job4j.generics;

public class Role extends Base {

    private final String roleUser;

    public Role(String id, String roleUser) {
        super(id);
        this.roleUser = roleUser;
    }

    public String getRole() {
        return roleUser;
    }
}
