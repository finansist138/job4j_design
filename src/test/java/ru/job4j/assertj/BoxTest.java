package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        assertThat(box.whatsThis())
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        assertThat(box.whatsThis())
                .isNotEmpty()
                .doesNotContain("Kvadrat")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void getNumberOfVertices4() {
        Box box = new Box(4, 4);
        assertThat(box.getNumberOfVertices())
                .isPositive()
                .isNotNull()
                .isEqualTo(4);
    }

    @Test
    void getNumberOfVertices0() {
        Box box = new Box(0, 4);
        assertThat(box.getNumberOfVertices())
                .isEven()
                .isEqualTo(0);
    }

    @Test
    void isExist() {
        Box box = new Box(8, 12);
        assertThat(box.isExist())
                .isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(-1, 12);
        assertThat(box.isExist())
                .isFalse();
    }

    @Test
    void getArea() {
        Box box = new Box(4, 4);
        assertThat(box.getArea()).isPositive()
                .isNotNull()
                .isCloseTo(27.71, Percentage.withPercentage(0.1));
    }

    @Test
    void notGetArea() {
        Box box = new Box(-1, 4);
        assertThat(box.getArea()).isEqualTo(0);

    }
}