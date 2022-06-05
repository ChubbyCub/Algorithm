package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationRepetionAllowed {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> list = new ArrayList<>();
        helper(nums, 6, new StringBuilder(), list);
        System.out.println(list);
    }

    private static void helper(int[] nums, int size, StringBuilder sb, List<String> list) {
        if (size == 0) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            helper(nums, size - 1, sb, list);
            sb.setLength(sb.length() - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
