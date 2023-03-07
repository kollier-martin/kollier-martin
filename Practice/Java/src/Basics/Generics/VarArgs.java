package io.beansprout.Basics.Generics;

/**
 * VarArgs
 * <p>
 * Using varargs 'Type...' indicates using arguments passed into the method's arguments
 */

public class VarArgs {
    public static void main(String[] args) {
        printShoppingList("Banana", "Apple", "Lotion", "Shoes", "Bucket");
    }

    public static void printShoppingList(String... items) {
        System.out.println("Shopping List");

        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + ": " + items[i]);
        }

        System.out.println();
    }
}
