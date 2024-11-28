package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "six", "ten");
        assertThat(list).hasSize(4)
                .contains("one", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .allSatisfy(e -> assertThat(e).hasSize(3));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "two", "six", "ten");
        assertThat(set).hasSize(4)
                .contains("two")
                .doesNotContain("zero")
                .endsWith("six", "one", "ten", "two")
                .first().isEqualTo("six");

    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "1", "two", "2", "six", "6", "ten", "10");
        assertThat(map).hasSize(8)
                .containsValues(1, 7, 3, 5, 0, 4, 6, 2)
                .doesNotContainEntry("free", 3);
    }
}