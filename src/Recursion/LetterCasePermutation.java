package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String input = "t1D2";
//        String input = "12345";
//        String input = "abc";

        List<String> list = new ArrayList<>();
        helper(input, 0, new StringBuilder(), list);
        System.out.println(list);
    }

    private static void helper(String input, int curr, StringBuilder sb, List<String> list) {
        if (curr == input.length()) {
            list.add(sb.toString());
            return;
        }
        char currChar = input.charAt(curr);
        if (Character.isLetter(currChar)) {
            helper(input, curr + 1, sb.append(Character.toLowerCase(input.charAt(curr))), list);
            sb.setLength(sb.length() - 1);
            helper(input, curr + 1, sb.append(Character.toUpperCase(input.charAt(curr))), list);
            sb.setLength(sb.length() - 1);
        } else {
            helper(input, curr + 1, sb.append(input.charAt(curr)), list);
            sb.setLength(sb.length() - 1);
        }
    }
}
