package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void namesLengthZero() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("is empty");
    }

    @Test
    void namesDoesNotContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String names = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(names)
                .hasMessageContaining("symbol");
    }

    @Test
    void namesDoesNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        String names = "=value";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(names)
                .hasMessageContaining("key");
    }

    @Test
    void namesDoesNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        String names = "key=";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(names)
                .hasMessageContaining("value");
    }
}