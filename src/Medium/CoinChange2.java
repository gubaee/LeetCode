package Medium;

import java.util.HashSet;

public class CoinChange2 {
    // https://leetcode.com/problems/coin-change-2/
    public static void main(String args[]) {
        int [] array = {1,2,5};
        System.out.println(change(5, array));
        String s = "";


    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; x++) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}
