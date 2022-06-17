package Sorting;

import java.util.Arrays;
import java.util.Objects;

public class DutchNationalFlag {
    public static void main(String[] args) {
//        String[] balls = new String[] {"G", "B", "G", "G", "R", "B", "R", "G"};
//        partition(balls);

        String[] balls2 = new String[] {"R", "B", "G", "R", "R", "B", "R", "G"};
        partition(balls2);
//        System.out.println(Arrays.toString(balls));
        System.out.println(Arrays.toString(balls2));
    }

    private static void partition(String[] array) {
        int red = 0;
        int green = 0;
        int blue = array.length - 1;

        while (green <= blue) {
            if (Objects.equals(array[green], "R")) {
                swap(array, red, green);
                red++;
                green++;
            } else if (Objects.equals(array[green], "B")) {
                swap(array, green, blue);
                blue--;
            } else {
                green++;
            }
        }
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
