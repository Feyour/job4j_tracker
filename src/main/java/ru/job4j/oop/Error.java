package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);

    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorPam = new Error(true, 15, "one");
        Error errorPam2 = new Error(false, 27, "two");
        Error errorPam3 = new Error(true, 948, "java");
        errorPam.printInfo();
        errorPam2.printInfo();
        errorPam3.printInfo();
    }
}
