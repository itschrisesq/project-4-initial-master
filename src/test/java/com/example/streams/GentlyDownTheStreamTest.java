package com.example.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GentlyDownTheStreamTest {

    private GentlyDownTheStream stream;

    @BeforeEach
    void setUp() {

        stream = new GentlyDownTheStream();
    }

    @Test
    void sortedFruits() {

        List<String> expected = stream.fruits.stream()
                                             .sorted()
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruits();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void sortedFruitsException() {

        List<String> expected = stream.fruits.stream()
                                             .filter(x -> !x.startsWith("A"))
                                             .sorted()
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruitsException();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void sortedFruitsFirstTwo() {

        List<String> expected = stream.fruits.stream()
                                             .sorted()
                                             .limit(2)
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruitsFirstTwo();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void commaSeparatedListOfFruits() {

        String expected = stream.fruits.stream()
                                       .sorted()
                                       .collect(Collectors.joining(", "));
        String actual = stream.commaSeparatedListOfFruits();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void reverseSortedVeggies() {

        List<String> expected = stream.veggies.stream()
                                              .sorted(Comparator.reverseOrder())
                                              .collect(Collectors.toList());
        List<String> actual = stream.reverseSortedVeggies();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void reverseSortedVeggiesInUpperCase() {

        List<String> expected = stream.veggies.stream()
                                              .sorted(Comparator.reverseOrder())
                                              .map(v -> v.toUpperCase(Locale.ROOT))
                                              .collect(Collectors.toList());
        List<String> actual = stream.reverseSortedVeggiesInUpperCase();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void topTen() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTen();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void topTenUnique() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .distinct()
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTenUnique();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void topTenUniqueOdd() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .distinct()
                                                     .filter(x -> x % 2 != 0)
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTenUniqueOdd();

        assertThat(actual.equals(expected)).isTrue();
    }

    @Test
    void average() {

        Double expected = stream.integerValues.stream()
                                              .mapToInt(i -> i)
                                              .average()
                                              .getAsDouble();
        Double actual = stream.average();

        assertThat(actual.equals(expected)).isTrue();
    }
}
