package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            int result = -1;
            for (int i = 0; i < value.length; i++) {
                if (value[i].equals(key)) {
                    result = i;
                }
            }
            if (result == -1) {
                throw new ElementNotFoundException("Element '" + key + "' not found.");
            }
            return result;
        }

        public static void main(String[] args) {
            String[] shops = {"Ebay", "Amazon", "Ozon"};
            try {
                int index = indexOf(shops, "Ozon");
                System.out.println("Нашли элемент, его номер: " + index);
            } catch (ElementNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}