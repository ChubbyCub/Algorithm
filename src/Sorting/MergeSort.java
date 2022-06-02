package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] test1 = new int[] {4, 3, 2, 1};

        sort(test1);
        System.out.println(Arrays.toString(test1));
    }

    private static void sort(int[] array) {
        helper(array, 0, array.length - 1);
    }

    private static void helper(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        helper(array, start, mid);
        helper(array, mid + 1, end);
        merge(array, start, end, mid);
    }

    private static void merge(int[] array, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int curr = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[curr++] = array[i++];
            } else {
                temp[curr++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[curr++] = array[i++];
        }

        while (j <= end) {
            temp[curr++] = array[j++];
        }

        System.arraycopy(temp, 0, array, 0 + start, temp.length);
    }
}
