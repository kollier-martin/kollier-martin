package io.beansprout.CodingChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AppleAndOrange {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // s is one end of the roof
        // t is the other end of the roof
        // The fallen fruit have to be between s and t

        // The apple tree is located at a
        // The orange tree is located at b

        // List size is the number of fruits that was thrown
        // List index is the distance per fruit that was thrown

        // Each index has to be summed with the tree location, per its respective fruit
        List<Integer> summedOranges = new ArrayList<>();
        List<Integer> summedApples = new ArrayList<>();
        int sumOfApple = 0;
        int sumOfOrange = 0;

        for (Integer fallenOrange : oranges) {
            summedOranges.add(fallenOrange + b);
        }

        for (Integer fallenApple : apples) {
            summedApples.add(fallenApple + a);
        }

        // Print Apples first, then Oranges
        for (Integer appleFallen : summedApples) {
            if (appleFallen <= t && appleFallen >= s) {
                sumOfApple++;
            }
        }

        for (Integer orangeFallen : summedOranges) {
            if (orangeFallen <= t && orangeFallen >= s) {
                sumOfOrange++;
            }
        }

        System.out.println(sumOfApple);
        System.out.println(sumOfOrange);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        AppleAndOrange.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}

