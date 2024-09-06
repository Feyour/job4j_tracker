package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество паасажиров " + count);
    }

    @Override
    public int refuel(int fuel) {
        int fuelCost = 52;
        return fuel * fuelCost;
    }
}
