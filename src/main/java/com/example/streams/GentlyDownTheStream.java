package com.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class GentlyDownTheStream {

    protected List<String> fruits;
    protected List<String> veggies;
    protected List<Integer> integerValues;

    public GentlyDownTheStream() {
        fruits = Arrays.asList("Apple", "Orange", "Banana", "Pear", "Peach", "Tomato");
        veggies = Arrays.asList("Corn", "Potato", "Carrot", "Pea", "Tomato");
        integerValues = new Random().ints(0, 1001)
                                    .boxed()
                                    .limit(1000)
                                    .collect(Collectors.toList());
    }

    public List<String> sortedFruits() {
        return fruits.stream()
                     .sorted()
                     .collect(Collectors.toList());
    }

    public List<String> sortedFruitsException() {
        return fruits.stream()
                .filter(x -> !x.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> sortedFruitsFirstTwo() {
        return fruits.stream()
                .sorted()
                .limit(2)
                .collect(Collectors.toList());
    }

    public String commaSeparatedListOfFruits() {
        return fruits.stream()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public List<String> reverseSortedVeggies() {
        return veggies.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<String> reverseSortedVeggiesInUpperCase() {
        return veggies.stream()
                .sorted(Comparator.reverseOrder())
                .map(v -> v.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    public List<Integer> topTen() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Integer> topTenUnique() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Integer> topTenUniqueOdd() {
        return integerValues.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .filter(x -> x % 2 != 0)
                .limit(10)
                .collect(Collectors.toList());
    }
    public Double average() {
        return integerValues.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }
}
