package CodingChallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses instance = new LongestValidParentheses();

        System.out.println(instance.longestValidParentheses(")()())"));
    }

    // First Try (Fail)
    public boolean sumOfValidParentheses(String s) {
        char[] parentheses = s.toCharArray();
        int counter;

        Map<Character, Integer> tester = new HashMap<>();

        for (char p : parentheses) {
            if (tester.containsKey(p)) {
                counter = tester.get(p);
                tester.put(p, counter++);
            } else {
                tester.put(p, 1);
            }
        }

        System.out.println(tester);

        for (char p : tester.keySet()) {
            if (tester.get(p) > 1) {
                return true;
            }
        }

        return false;
    }

    // GeekForGeek Way
    public int longestValidParentheses(String s) {
        int result = 0;
        int count = 0;

        // Convert string to char array
        char[] sToChar = s.toCharArray();

        // Create a stack with an initial index
        Stack<Integer> stack = new Stack<>() {
            {
                push(-1);
            }
        };

        do {
            // If outside bracket, push index (beginning of set)
            if (sToChar[count] == '(') {
                stack.push(count);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }

                if (!stack.empty()) {
                    result = Math.max(result, count - stack.peek());
                } else {
                    stack.push(count);
                }
            }
            count++;
        } while (count < s.length());

        return result;
    }
}
