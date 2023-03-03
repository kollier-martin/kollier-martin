package CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;

public class AlmostPalindrome {
    public static void main(String[] args) {
        ArrayList<String> areThesePalindromes =
                new ArrayList<>(Arrays.asList("abcdcbg", "abccia", "abcdaaa", "1234312", "abba"));

        areThesePalindromes
                .forEach(s -> System.out.println(almostPalindrome(s)));
    }

    public static boolean almostPalindrome(String text) {
        boolean isPalindrome = false;
        char[] textChars = text.toCharArray();
        int strLength = textChars.length;
        char[] temp = new char[strLength];

        // How can I tell a string is a palindrome?
        // If reverse string has one off value from the original string then it is palindrome
        // If number is involved in the text, short circuit
        for (char c : textChars) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        // Create temp char array to compare to the given char array
        for (int i = 0; i < strLength; i++) {
            temp[strLength - i - 1] = textChars[i];
        }

        // If compareTo returns -1, then decrement count, if it returns 1, it is a possible palindrome
        int count = strLength;
        while (count != 0) {
            if (Arrays.toString(temp).compareTo(Arrays.toString(textChars)) < 0) {
                count--;
            } else {
                isPalindrome = true;
                break;
            }
        }

        return isPalindrome;
    }
}
