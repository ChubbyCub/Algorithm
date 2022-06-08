package String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "babad";
        String result = longestPalindrome(input);
        System.out.println(result);
    }

    private static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = check(s, i, i);
            int even = check(s, i, i + 1);
            length = Math.max(odd, even);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int check(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
