package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer last = null;
        for (int i = 0; i < queue.size(); i++) {
            if (count > i) {
                last = queue.poll();
            }
        }
        return last.name();
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            if (count > i) {
                queue.poll();
            }
        }
        Customer first = queue.element();
        return first.name();
    }
}