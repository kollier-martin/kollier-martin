package io.beansprout.CodingChallenges;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PairSums {

    /*
     * https://www.hackerrank.com/challenges/pair-sums/problem
     * Complete the 'largestValue' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static long largestValue(List<Integer> A) {
        long largest = 0L;

        // TODO: Address constraints at the end of the project
        // A = [-3, 7, -2, 3, 5, -2]    Initial input

        // Expected Output
        // (-3, 7) (-3, -2) (-3, 3) (-3, 5) (-3, -2)    First run through first for loop -21, 6, -9, -15, 6
        // (7, -2) (7, 3) (7, 5) (7, -2)                Second run -14, 21, 35, -14
        // (-2, 3) (-2, 5) (-2, -2)                     Third run -6, -10, 4
        // (3, 5) (3, -2)                               Fourth run 15, -6
        // (5, -2)                                      Last run -10
        // Sum of Products = -18
        // Largest Value of Possible Pairs = [7, -2, 3, 5] = (7, -2) + (7, 3) + (7, 5) + (-2, 3) + (3, 5) = 41

        // Break down List into SubList, multiply the pairs of the sub list
        // Break it down into a key value pair?
        ArrayList<Integer> pairs = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // I need index 0 and for every index increase, item 2 should be index++
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                pairs.add(A.get(j));
            }

            map.put(A.get(i), pairs);
        }


        // Return the largest value of A's nonempty sub arrays.
        return largest;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileDescriptor.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = PairSums.largestValue(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

