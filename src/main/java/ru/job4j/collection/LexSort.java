package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("\\.");
        String[] rightString = right.split("\\.");
        int l = Integer.parseInt(leftString[0]);
        int r = Integer.parseInt(rightString[0]);
        return Integer.compare(l, r);
    }
}