package io.beansprout.CodingChallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class MultiSum {
    public static Integer sum(Integer[] ints) {
        int sum = 0;

        for (Integer i : ints) {
            sum += i;
        }

        return sum;
    }

    public static String sum(String[] strings) {
        String concatenatedString = "";

        for (String s : strings) {
            concatenatedString = concatenatedString.concat(s);
        }

        return concatenatedString;
    }

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        Integer[] ints = new Integer[100];
        String[] strings = new String[100];

        // Input is single line with spaces?
        // BufferedReader not Scanner
        // but a new issue arises, BR is string only, doesn't matter I think
        System.out.println("Provide Input" +
                "\n=============");
        input = br.readLine().split(" ");

        try {
            for (int i = 0; i < input.length; i++) {
                ints[i] = Integer.parseInt(input[i]);
            }

            // Remove nulls
            ints = Arrays.stream(ints)
                    .filter(Objects::nonNull)
                    .toArray(Integer[]::new);

            System.out.println(sum(ints));
        } catch (Exception e) {
            System.arraycopy(input, 0, strings, 0, input.length);

            // Remove nulls
            strings = Arrays.stream(strings)
                    .filter(Objects::nonNull)
                    .toArray(String[]::new);

            System.out.println(sum(strings));
        }
    }
}
