package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("feyour@gmail.com", "Albert Gabaydullin");
        map.put("gab_56@mail.ru", "Arthur Gabaydullin");
        map.put("gab_56@mail.ru", "Maria Steblevsya");
        map.put("gab_56@mail.ru", "Masha");
        map.put("job4j@gamil.com", "Albert Gabaydullin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
