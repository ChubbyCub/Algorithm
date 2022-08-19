package Graph;

import java.sql.Array;
import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

    }

    private static ArrayList<String> string_transformation(ArrayList<String> wordList, String beginWord, String endWord) {
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        dict.remove(endWord);
        if (beginWord.equals(endWord)) {
            return new ArrayList<>(List.of("-1"));
        }
        if (isOneCharacterAway(beginWord, endWord) && wordList.size() == 0) {
            return new ArrayList<>(List.of(beginWord, endWord));
        }
        return bfs(dict, beginWord, endWord);
    }

    private static ArrayList<String> createAns(Map<String, String> backRef, String curr, String endWord) {
        ArrayList<String> ans = new ArrayList<>();
        ans.add(endWord);
        while(curr != null) {
            ans.add(curr);
            curr = backRef.get(curr);
        }
        Collections.reverse(ans);
        return ans;
    }

    private static ArrayList<String> bfs(Set<String> dict, String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> backRef = new HashMap<>();

        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            String currWord = queue.poll();
            Set<String> neighbors = new HashSet<>();
            if (dict.size() > 26 * currWord.length()) {
                neighbors = getNeighbors2(dict, currWord, endWord);
            } else {
                neighbors = getNeighbors1(dict, currWord, endWord);
            }

            for (String neighbor : neighbors) {
                if (neighbor.equals(endWord)) {
                    return createAns(backRef, currWord, endWord);
                }
                if (visited.contains(neighbor)) continue;
                visited.add(neighbor);
                queue.offer(neighbor);
                backRef.put(neighbor, currWord);
            }
        }
        return new ArrayList<>(List.of("-1"));
    }

    private static Set<String> getNeighbors1(Set<String> wordList, String currWord, String endWord) {
        Set<String> neighbors = new HashSet<>();
        for (String word : wordList) {
            if (isOneCharacterAway(currWord, endWord)) {
                neighbors.add(endWord);
            }
            if (isOneCharacterAway(currWord, word)) {
                neighbors.add(word);
            }
        }
        return neighbors;
    }

    private static Set<String> getNeighbors2(Set<String> wordList, String currWord, String endWord) {
        Set<String> neighbors = new HashSet<>();
        for (int i = 0; i < currWord.length(); i++) {
            char[] candidate = currWord.toCharArray();
            char original = candidate[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    candidate[i] = c;
                    String candidateStr = String.valueOf(candidate);
                    if (wordList.contains(candidateStr) | candidateStr.equals(endWord)) {
                        neighbors.add(candidateStr);
                    }
                }
            }
        }
        return neighbors;
    }

    private static boolean isOneCharacterAway(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int countDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) countDiffs++;
            if (countDiffs > 1) return false;
        }

        return countDiffs == 1;
    }
}
