package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void withPattern() {
        String path = "./data/withPattern.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect")).
                isEqualTo("org.hibernate.dialect.PostgreSQLDialect");
    }

    @Test
    void breakPattern1() {
        String path = "./data/breakPattern1.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void breakPattern2() {
        String path = "./data/breakPattern2.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=1");
    }

    @Test
    void breakPattern3() {
        String path = "./data/breakPattern3.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void breakPattern4() {
        String path = "./data/breakPattern4.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }
}