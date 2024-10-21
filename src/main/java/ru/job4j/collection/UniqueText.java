package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String s : origin) {
            check.add(s);
        }

        for (String s : check) {
            for (String string : text) {
                if (!check.contains(string)) {
                    return false;
                }
            }
        }
        return true;
    }
}