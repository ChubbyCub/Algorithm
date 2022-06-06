package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintDecimalStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        helper(2, list, new StringBuilder());
        System.out.println(list);
    }

    private static void helper(int size, List<String> list, StringBuilder sb) {
        if (size == 0) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i <= 9; i++) {
            sb.append(i);
            helper(size - 1, list, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
