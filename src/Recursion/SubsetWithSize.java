package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithSize {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] input = new int[] {1, 2, 3};
        helper(input, 2, 0, new ArrayList<>(), list);
        System.out.println(list);
    }

    private static void helper(int[] input, int k, int curr, List<Integer> soFar, List<List<Integer>> list) {
        if (soFar.size() == k) {
            list.add(new ArrayList<>(soFar));
            return;
        }

        if (curr == input.length) return;

        soFar.add(input[curr]);
        helper(input, k, curr + 1, soFar, list);
        soFar.remove(soFar.size() - 1);
        helper(input, k, curr + 1, soFar, list);
    }
}
