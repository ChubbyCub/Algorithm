package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecompositionOfAString {
    public static void main(String[] args) {
        String input = "abracadabra";
        List<String> list = new ArrayList<>();
        helper(input, 0, 0, new StringBuilder(), list);
        System.out.println(list);
    }

    static void helper(String s, int start, int end, StringBuilder sb, List<String> list) {
        if (end == s.length() - 1) {
            sb.append(s.charAt(end));
            if (isPalindrome(s, start, end)) {
                list.add(sb.toString());
            }
            sb.setLength(sb.length() - 1);
            return;
        }

        sb.append(s.charAt(end));
        if (isPalindrome(s, start, end)) {
            sb.append('|');
            helper(s, end + 1, end + 1, sb, list);
            sb.setLength(sb.length() - 1);
            helper(s, start, end + 1, sb, list);
        } else {
            helper(s, start, end + 1, sb, list);
        }
        sb.setLength(sb.length() - 1);
    }


    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
