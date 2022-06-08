package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonics {
    private static String[] MAPPING = new String[] {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        List<String> mnemonics = new ArrayList<>();
        String input = "89";
        helper(input, 0, mnemonics, new StringBuilder());
        System.out.println(mnemonics);
    }

    private static void helper(String input, int curr, List<String> list, StringBuilder sb) {
        if (curr == input.length()) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < MAPPING[input.charAt(curr) - '0'].length(); i++) {
            sb.append(MAPPING[input.charAt(curr) - '0'].charAt(i));
            helper(input, curr + 1, list, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
