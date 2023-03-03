package CodingChallenges;

public class StringContains {
    public static void main(String[] args) {
        System.out.println(contains("The quick brown fox jumps over the lazy dog.", "fox"));
    }

    private static boolean contains(final String statement, final String key) {
        char[] statementBytes = statement.toCharArray();
        char[] keyBytes = key.toCharArray();
        boolean isPresent = false;
        int counter = 0;

        if (key.isEmpty() || statement.isEmpty()) {
            return isPresent;
        }

        for (char statementByte : statementBytes) {
            if (statementByte == keyBytes[counter]) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == keyBytes.length) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }
}
