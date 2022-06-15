package Recursion;

import java.util.List;
import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        int[] input = new int[] {1, 5, 3, -2, 6, -4};
        List<List<Integer>> list = new ArrayList<>();
        helper(input, 0, 4, new ArrayList<>(), list);
        System.out.println(list);
    }

    private static void helper(int[] input, int curr, int target, List<Integer> soFar, List<List<Integer>> list) {
        if (isEqual(soFar, target)) {
            list.add(new ArrayList<>(soFar));
            return;
        }

        if (curr == input.length) {
            return;
        }

        soFar.add(input[curr]);
        helper(input, curr + 1, target, soFar, list);
        soFar.remove(soFar.size() - 1);
        helper(input, curr + 1, target, soFar, list);
    }

    private static boolean isEqual(List<Integer> soFar, int target) {
        int sum = 0;
        for (Integer num : soFar) {
            sum += num;
        }
        return sum == target;
    }
}
