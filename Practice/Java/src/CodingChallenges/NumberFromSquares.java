package CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberFromSquares {
    public static void main(String[] args) {
        ArrayList<Integer> numToUse =
                new ArrayList<>(Arrays.asList(203, 11, 107));

        numToUse
                .forEach(s -> System.out.println(isHappy(s)));
    }

    public static boolean isHappy(int num) {
        int temp;

        do {
            temp = num % 10;

            if (temp == 4) {
                return false;
            } else if (temp == 1) {
                return true;
            }

            num = num / 10;
        } while (num > 0);

        return false;
    }
}
