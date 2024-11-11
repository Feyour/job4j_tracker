package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 45, -104, 735, 32, -18, 0, -1);
        List<Integer> positive = numbers.stream()
                .filter(num -> num > 0)
                .sorted()
                .toList();
        positive.forEach(System.out::println);
    }
}