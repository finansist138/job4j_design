package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void withCommentAndEmptyLine() {
        String path = "./data/withCommentAndEmptyLine.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect")).
                isEqualTo("org.hibernate.dialect.PostgreSQLDialect");
        assertThat(config.value("hibernate.connection.url")).
                isEqualTo("jdbc:postgresql://127.0.0.1:5432/trackstudio");
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
}