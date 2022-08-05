package Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> graph = buildGraph(wordList);
        if (!graph.containsKey(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, String> backRef = new HashMap<>();
        queue.add(beginWord);
        backRef.put(beginWord, null);

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            boolean found = false;
            for (String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (backRef.containsKey(neighbor)) continue;
                backRef.put(neighbor, curr);
                if (neighbor.equals(endWord)) {
                    found = true;
                    break;
                }
                queue.add(neighbor);
            }
            if (found) break;
        }

        if (!backRef.containsKey(endWord)) return 0;
        String curr = endWord;
        int count = 0;

        while (curr != null) {
            count++;
            curr = backRef.get(curr);
        }

        return count;
    }

    private static Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String word_one : wordList) {
            graph.putIfAbsent(word_one, new ArrayList<>());
            for (String word_two: wordList) {
                if (isOneCharacterAway(word_one, word_two)) {
                    graph.get(word_one).add(word_two);
                }
            }
        }

        return graph;
    }

    private static boolean isOneCharacterAway(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int countDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) countDiffs++;
        }

        return countDiffs == 1;
    }
}
