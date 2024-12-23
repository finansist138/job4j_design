package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleModelIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.add(new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceThenRoleIsDriver() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("1", new Role("1", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Driver");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("10", new Role("10", "Driver"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleUserIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("1", new Role("1", "Driver"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("10", new Role("10", "Driver"));
        assertThat(result).isFalse();
    }
}