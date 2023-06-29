package io.beansprout.CodingChallenges;

import java.io.*;
import java.util.stream.IntStream;

public class BalancedBraces {
    // Chars to check for
    String[] braces = new String[] {"(", ")", "[", "]", "{", "}"};

    public static String isBalanced(String s) {
        String isBalanced = "true";
        String isNotBalanced = "false";

        // Checks to short circuit edge cases (excluding checking for any char other than the ones designated)
        if ((null == s)) {
            return isNotBalanced;
        }

        // Removes every match case, if anything remains after this purge, then the string is unbalanced
        while(s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s
                    .replaceAll("\\(\\)", "")
                    .replaceAll("\\[]", "")
                    .replaceAll("\\{}", "");
        }

        if (s.length() != 0) {
            return isNotBalanced;
        }

        return isBalanced;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBraces.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
