package Searching;

// Need to rewrite this
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        int rotatedIndex = findRotatedIndex(nums);
        if (target > rotatedIndex) {
            System.out.println(binarySearch(nums, 0, rotatedIndex - 1, target));
        } else {
            System.out.println(binarySearch(nums, rotatedIndex, nums.length - 1, target));
        }
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, mid + 1, end, target);
        }
        return binarySearch(nums, start, mid - 1, target);
    }

    private static int findRotatedIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }
}
