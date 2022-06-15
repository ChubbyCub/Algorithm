package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        helper(2, 7, list, new ArrayList<>());
        System.out.println(list);
    }

    private static void helper(int numDice, int target, List<List<Integer>> list, List<Integer> soFar) {
        if (target < 0) {
            return;
        }

        if (soFar.size() == numDice) {
            if (target == 0) {
                list.add(new ArrayList<>(soFar));
            }
            return;
        }
        for (int i = 1; i <= 6; i++) {
            soFar.add(i);
            helper(numDice, target - i, list, soFar);
            soFar.remove(soFar.size() - 1);
        }
    }
}
