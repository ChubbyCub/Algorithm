package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] test1 = new int[] {4, 3, 2, 1};
        int[] test2 = new int[] {1, 2, 3, 4};
        int[] test3 = new int[] {4, 4, 2, 1};
        int[] test4 = new int[] {4, 4, 4, 4};
        int[] test5 = new int[] {2, -1, 4};
        int[] test6 = new int[0];
        sort(test1);
        sort(test2);
        sort(test3);
        sort(test4);
        sort(test5);
        sort(test6);
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
        System.out.println(Arrays.toString(test5));
        System.out.println(Arrays.toString(test6));
    }

    private static void sort(int[] array) {
        helper(array, 0, array.length - 1);
    }

    private static void helper(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int pivotIndex = (int) ((Math.random() * (end - start)) + start);
        int partitionIdx = partition(array, start, end, pivotIndex);
        helper(array, start, partitionIdx - 1);
        helper(array, partitionIdx + 1, end);
    }

    private static int partition(int[] array, int start, int end, int pivotIndex) {
        int pivot = array[pivotIndex];
        int curr = start;
        swap(array, pivotIndex, end);
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, curr, i);
                curr++;
            }
        }
        swap(array, curr, end);
        return curr;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
