package ru.job4j.pojo;

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(int receiptDate) {
        this.receiptDate = receiptDate;
    }

    private String group;
    private int receiptDate;
}
