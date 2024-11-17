package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var name = (Predicate<Person>) person -> person.getName().contains(key);
        var phone = (Predicate<Person>) person -> person.getPhone().contains(key);
        var surname = (Predicate<Person>) person -> person.getSurname().contains(key);
        var address = (Predicate<Person>) person -> person.getAddress().contains(key);
        var combine = name.or(phone).or(surname).or(address);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}