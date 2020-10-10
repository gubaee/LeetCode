public class longestPalindrome {
    public static void main(String args[]) {
        System.out.println(longestPalindrome("ac"));
    }
    public static String longestPalindrome(String s) {
        String resultString = "";
        int oddLength = 0;
        int evenLength = 0;
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            oddLength = maxPalindrome(s, i, i)-1;
            evenLength = maxPalindrome(s, i, i+1);
            if (Math.max(oddLength, evenLength) > longestLength) {
                longestLength = Math.max(oddLength, evenLength);
                if (oddLength >= evenLength) {
                    resultString = s.substring(i-oddLength/2, i+oddLength/2+1);
                } else {
                    resultString = s.substring(i-evenLength/2+1, i+evenLength/2+1);
                }
            }
        }
        return resultString;
    }
    public static int maxPalindrome(String s, int leftIndex, int rightIndex) {
        int palindromeLength = 0;
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            palindromeLength+=2;
            leftIndex--;
            rightIndex++;
            // b a a b
        }
        return palindromeLength;
    }
}
