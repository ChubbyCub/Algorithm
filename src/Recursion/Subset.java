package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        helper(input, 0, new ArrayList<>(), list);
        System.out.println(list);
    }

    private static void helper(int[] input, int curr, List<Integer> soFar, List<List<Integer>> list) {
        if (curr == input.length) {
            list.add(new ArrayList<>(soFar));
            return;
        }

        soFar.add(input[curr]);
        helper(input, curr + 1, soFar, list);
        soFar.remove(soFar.size() - 1);
        helper(input, curr + 1, soFar, list);
    }
}
