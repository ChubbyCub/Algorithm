package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicographicalOrder {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("key1 abcd");
        input.add("key2 zzz");
        input.add("key1 hello");
        input.add("key3 world");
        input.add("key1 hello");

        System.out.println(solve(input));
    }

    private static List<String> solve(List<String> input) {
        Map<String, Integer> countKeys = new HashMap<>();
        Map<String, String> ranks = new HashMap<>();

        for (String s : input) {
            String[] split = s.split(" ");
            countKeys.put(split[0], countKeys.getOrDefault(split[0], 0) + 1);
            if (!ranks.containsKey(split[0])) {
                ranks.put(split[0], split[1]);
            } else {
                if (split[1].compareTo(ranks.get(split[0])) > 0) {
                    ranks.put(split[0], split[1]);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (String key : countKeys.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append(':');
            sb.append(countKeys.get(key));
            sb.append(',');
            sb.append(ranks.get(key));
            result.add(sb.toString());
        }

        return result;
    }
}
