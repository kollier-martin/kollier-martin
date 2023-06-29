package io.beansprout.CodingChallenges;

import java.io.*;

public class Kangaroo {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Kangaroo.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        String no = "NO";
        String yes = "YES";

        // Kangaroo 1 starts at x1 and travels v1 meters per jump
        // Kangaroo 2 starts at x2 and travels v2 meters per jump
        // The goal is to decide if both kangaroos reach the same destination eventually
        while (x1 <= x2) {
            x1 += v1;
            x2 += v2;

            // If kangaroo 1 or 2 starts further and moves further, short circuit to no
            if ((x2 > x1 && v2 > v1) || (x1 > x2 && v1 > v2)) {
                return no;
            }

            if (x1 == x2) {
                // If the kangaroos are in the same position, then yes
                return yes;
            }
        }

        // Specified conditions are not met
        return no;
    }

}
