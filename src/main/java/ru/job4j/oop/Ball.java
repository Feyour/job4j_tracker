package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            String run = "Колобок сбежал.";
            System.out.println(run);
        } else {
            String run = "Колобок съеден.";
            System.out.println(run);
        }
    }
}
