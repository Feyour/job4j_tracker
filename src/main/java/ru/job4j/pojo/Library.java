package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book aStudyInScarlet = new Book("Этюд в багровых тонах", 264);
        Book theWholeWorldIsATheater = new Book("Весь мир театр", 300);
        Book soulDrinker = new Book("Испивающие души", 840);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = aStudyInScarlet;
        books[2] = theWholeWorldIsATheater;
        books[3] = soulDrinker;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages() + " страниц.");
        }
        System.out.println();
        books[0] = soulDrinker;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages() + " страниц.");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages() + " страниц.");
            }
        }
    }
}
