package Sorting;
import java.util.*;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 4, 4, 2};
        int k = 3;
        System.out.println(topK(arr, k));
    }

    private static List<Integer> topK(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for (Integer num : arr) {
            ts.add(num);
            if (ts.size() > k) {
                ts.pollFirst();
            }
        }

        while(!ts.isEmpty()) {
            result.add(ts.pollFirst());
        }

        return result;
    }
}
