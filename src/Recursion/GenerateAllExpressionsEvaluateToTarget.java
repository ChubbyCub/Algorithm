package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllExpressionsEvaluateToTarget {
    public static void main(String[] args) {
        String s = "202";
        int numSpaces = s.length() - 1;
        String[] operators = new String[] {"", "+", "*"};
        List<List<String>> choices = new ArrayList<>();
        // test generate all operator choices
        helper(operators, new ArrayList<>(), choices, 0, numSpaces);
        System.out.println(choices);
        // test build strings
        List<String> expressions = new ArrayList<>();
        for (List<String> choice : choices) {
            expressions.add(buildString(s, choice));
        }

        List<String> result = new ArrayList<>();
        for (String expression : expressions) {
            if (evaluate(expression) == 4) {
                result.add(expression);
            }
        }

        System.out.println(result);
    }

    // generate all possible choices by recursion
    private static void helper(String[] operators, List<String> soFar, List<List<String>> list, int curr, int numSpaces) {
        if (curr == numSpaces) {
            list.add(new ArrayList<>(soFar));
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            soFar.add(operators[i]);
            helper(operators, soFar, list, curr + 1, numSpaces);
            soFar.remove(soFar.size() - 1);
        }
    }

    private static String buildString(String s, List<String> choice) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(i < choice.size() && !choice.get(i).equals("")) {
                sb.append(choice.get(i));
            }
        }

        return sb.toString();
    }

    // function to evaluate
    /**
     * o1 == 1 means +; o1 == -1 means -
     * o2 == 1 means *; o2 == -1 means /
     * */
    private static int evaluate(String s) {
        int l1 = 0;
        int l2 = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = l2 * num;
            } else if (c == '+') {
                l1 = l1 + l2;
                l2 = 1;
            }
        }
        return l1 + l2;
    }
}
