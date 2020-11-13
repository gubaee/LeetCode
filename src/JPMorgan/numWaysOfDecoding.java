package JPMorgan;

public class numWaysOfDecoding {
    public static void main(String args[]) {
        System.out.println(numDecodings("10"));
    }
    public static int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {

            int singleDigit = Integer.valueOf(s.substring(i-1, i));
            int doubleDigit = Integer.valueOf(s.substring(i-2, i));

            if(singleDigit > 0) {
                dp[i] += dp[i-1];
            }
            if(doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}
