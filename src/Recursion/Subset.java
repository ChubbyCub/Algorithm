package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Subset {
    private static Set<List<Integer>> set;
    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 2};
        List<List<Integer>> list = new ArrayList<>();
        set = new HashSet<>();
        helper(input, 0, new ArrayList<>(), list);
        System.out.println(list);
    }

    private static void helper(int[] input, int curr, List<Integer> soFar, List<List<Integer>> list) {
        if (curr == input.length) {
            List<Integer> currList = new ArrayList<>(soFar);
            if (set.contains(currList)) return;
            set.add(currList);
            list.add(currList);
            return;
        }

        soFar.add(input[curr]);
        helper(input, curr + 1, soFar, list);
        soFar.remove(soFar.size() - 1);
        helper(input, curr + 1, soFar, list);
    }
}
