package io.beansprout.Basics.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lists And Methods
 * <p>
 * Generic just means a parameterized type, defining an Object type using <[Type]>
 * Ex: List vs List<String>, 'List<String>' is generic and 'List' is not
 * <p>
 * States that if you have a variable of a given type,
 * you can assign it to a value that is a subtype of the Building type
 * <p>
 * By default, this does not apply to list types
 */

public class ListsAndMethods {
    static Character[] characters = {'a', 'c', 'e', 'g', 'i'};
    static Integer[] integers = {2, 4, 6, 8, 10};
    static Boolean[] booleans = {true, false, false, true};

    public static void main(String[] args) {
        genericList();

        System.out.println(arrayToListSafe(characters, new ArrayList<>()));
        System.out.println(arrayToListSafe(integers, new ArrayList<>()));
        System.out.println(arrayToListSafe(booleans, new ArrayList<>()));
    }

    public static void genericList() {
        List notGeneric = new ArrayList<>();
        notGeneric.add("Happy");
        notGeneric.add(2);
        notGeneric.add('c');
        System.out.println("Non Generic ListsAndMethods: " + notGeneric);

        List<String> isGeneric = new ArrayList<>();
        isGeneric.add("Happy");
        isGeneric.add("Sad");
        // isGeneric.add(2); Can not do since a generic was specified
        System.out.println("Generic ListsAndMethods: " + isGeneric);
    }

    // Generic method that can convert any array to a list as long as it is an Object
    // Lacks type safety when not using Type 'T', causing a ClassCastException
    public static List arrayToListUnsafe(Object[] array, List<Object> list) {
        list.addAll(Arrays.asList(array));

        return (list);
    }

    // Flexible when declared using Type 'T'
    public static <T> List<T> arrayToListSafe(T[] array, List<T> list) {
        list.addAll(Arrays.asList(array));

        return list;
    }


}
