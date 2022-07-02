package String;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNumberSequence {
    public static void main(String[] args) {
        int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestSequence(nums));
    }

    private static int longestSequence(int[] nums) {
        // optimize by using a hash set
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            // if the set does not contain the number immediately prior to the current number
            // then we start building out the sequence
            // if the set already contains the number immediately prior to the current number
            // that means the current number is already considered part of some other sequence.
            // so we don't need to explore this option.
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak++;
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;
    }

    private static boolean arrayContains(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
