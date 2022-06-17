package Sorting;

import java.util.Arrays;

public class MergeOneSortedArrayIntoAnother {
    public static void main(String[] args) {
        int[] first = new int[] {4, 9, 8};
        int[] second = new int[] {2, 4, 6, 0, 0, 0};

        merge(first, second);

        System.out.println(Arrays.toString(second));
    }

    private static void merge(int[] first, int[] second) {
        int i = first.length - 1;
        int j = (second.length - 1) / 2;

        int end = second.length - 1;

        while(i >= 0 && j >= 0) {
            if (first[i] > second[j]) {
                second[end] = first[i];
                i--;
            } else {
                second[end] = second[j];
                j--;
            }
            end--;
        }

        while (j >= 0) {
            second[end] = second[j];
            j--;
            end--;
        }

        while (i >= 0) {
            second[end] = first[i];
            i--;
            end--;
        }
    }
}
