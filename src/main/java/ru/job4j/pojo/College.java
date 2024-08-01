package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов Андрей Викторович");
        student.setGroup("12-ПКС");
        student.setReceiptDate(2019);
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getReceiptDate());
    }
}
