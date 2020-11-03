package Medium;

public class CoinChange {
    public static void main(String args[]) {
        System.out.println(coinChange(new int [] {1,2,5}, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int [] dp = new int [amount+1];
        fillUpDpArray(dp);

        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                int currentCoin = coins[j];
                int indexToCheck = i-currentCoin;
                if (indexToCheck < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[indexToCheck]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE-1 || dp[amount] == 0 ? -1 : dp[amount];

    }
    public static void fillUpDpArray(int [] dp) {
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }
    }

}
