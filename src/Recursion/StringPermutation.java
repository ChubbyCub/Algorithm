package Recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        char[] input = new char[] {'H', 'A', 'T'};
        List<String> result = new ArrayList<>();

        helper(input, 0, result);
        System.out.println(result);
    }

    private static void helper(char[] input, int curr, List<String> list) {
        if (curr == input.length - 1) {
            String str = String.valueOf(input);
            list.add(str);
            return;
        }

        for (int i = curr; i < input.length; i++) {
            swap(input, i, curr);
            helper(input, curr + 1, list);
            swap(input, i, curr);
        }
    }

    private static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
