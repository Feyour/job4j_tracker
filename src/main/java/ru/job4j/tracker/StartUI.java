package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class StartUIq  {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter currentDateTimeFormat = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String date = item.getFormattedCreated(currentDateTimeFormat);
        System.out.println(date);
    }

}
