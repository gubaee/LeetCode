package Medium;

public class LongestPalindrome {
    public static void main(String args[]) {
        System.out.println(longestPalindrome("cbba"));
    }
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int odd = getPalindromeCount(s, i, i) - 1;
            int even = getPalindromeCount(s, i, i + 1);
            // b a b
            if (odd > even) {
                if (max < odd) {
                    max = odd;
                    left = i - (odd + 1) / 2 + 1;
                    right = i + ((odd + 1) / 2);
                }
            } else {
                // bbaabb
                // i = 2
                if (max < even) {
                    max = even;
                    left = i - (even / 2) + 1;
                    right = i + (even / 2) + 1;
                }
            }
        }
        return s.substring(left, right);
    }

    public static int getPalindromeCount(String s, int left, int right) {
        int result = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
        return result*2;
    }
}
