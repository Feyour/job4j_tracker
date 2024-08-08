package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class StartUI   {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime date =  item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedDate = date.format(formatter);

        System.out.println(formattedDate);
        System.out.println(item);
    }

}
