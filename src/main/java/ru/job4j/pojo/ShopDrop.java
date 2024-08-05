package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];

                }
            }
        }
        products[products.length - 1] = null;
        return products;
    }
}