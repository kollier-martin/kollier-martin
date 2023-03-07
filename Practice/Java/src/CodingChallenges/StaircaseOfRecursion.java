package io.beansprout.CodingChallenges;

import java.util.ArrayList;
import java.util.Arrays;

public class StaircaseOfRecursion {
    public static void main(String[] args) {
        ArrayList<Integer> steps =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        steps
                .forEach(s -> System.out.printf("Ways to Climb (%d): %d%n", s, staircase(s)));
    }

    public static Integer staircase(Integer num) {
        // Short circuit for efficiency
        if (num <= 1) {
            return 1;
        } else {
            // Recursively calculate steps using the given number since a person can only climb one step or two steps
            return staircase(num - 1) + staircase(num - 2);
        }
    }
}
