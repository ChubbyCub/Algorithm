package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationDuplicates {
    public static void main(String[] args) {
        String input = "ABAA";
        List<String> list = new ArrayList<>();
        helper(input.toCharArray(), 0, list);
        System.out.println(list);
    }

    private static void helper(char[] array, int curr, List<String> list) {
        if (curr == array.length - 1) {
            list.add(String.valueOf(array));
            return;
        }

        Set<Character> cache = new HashSet<>();
        for (int i = curr; i < array.length; i++) {
            if (cache.contains(array[i])) continue;
            cache.add(array[i]);
            swap(array, i, curr);
            helper(array, curr + 1, list);
            swap(array, i, curr);
        }
    }

    private static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
