package Basics;

import java.util.Locale;

@FunctionalInterface
public interface StringFormatter {
    String format(String string1, String string2);
}

class Tester {
    public static void main(String[] args) {
        String str1 = "Lambda";
        String str2 = "Expression";

        StringFormatter formatted = ((string1, string2) -> string1 + " " + string2);
        System.out.println(formatted.format(str1, str2));

        formatted = ((string1, string2) -> string1 + " - " + string2);
        System.out.println(formatted.format(str1, str2));

        formatted = ((string1, string2) -> string1.toUpperCase(Locale.ROOT) + " " + string2.toUpperCase(Locale.ROOT));
        System.out.println(formatted.format(str1, str2));
    }
}