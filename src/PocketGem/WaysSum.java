package PocketGem;

import java.math.BigInteger;

public class WaysSum {
    public static void main(String args[]) {
        System.out.println(ways(8, 2));
        System.out.println(ways(4, 2));
//        System.out.println(ways(619, 99));
//        System.out.println(ways(566, 21));
//        System.out.println(ways(842, 91));
    }
    public static int ways (int total, int k) {
        BigInteger[] dp = new BigInteger[total + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new BigInteger("0");
        }
        dp[0] = new BigInteger("1");
        int[] weights = new int[k];
        for (int i = 0; i < k; i++) {
            weights[i] = i + 1;
        }
        for (int weight : weights) {
            for (int x = weight; x < total + 1; ++x) {
                dp[x] = dp[x].add(dp[x - weight]);
            }
        }
        // 1000000007
        // 825974844099423840
//        dp[total] % x = 143119619;
        //1000000007
        //317600006
        //143119619

//        findDivisor(dp[total], 143119619);

        BigInteger num = new BigInteger("1000000007");
        BigInteger result = dp[total].mod(num);
        return result.intValue();
    }

    public static void findDivisor(long dividend, int remainder) {
        for (long i = remainder; i <= dividend/2; i++) {
            if (dividend % i == remainder) {
                System.out.println(i);
            }
            if (i % 1000000 == 0) {
//                System.out.println("result: " + dividend % i+ " i: "+i);
            }


        }
    }


//    static int result = 0;
//    public static int ways(int total, int k) {
//        int [] array = new int [k];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i+1;
//        }
//
//        helper(array, total, 0, 0, 0);
//
//        return result;
//    }
//
//    public static void helper(int [] array, int target, int curSum, int startIndex, int curIndex) {
//        if (target == curSum) {
//            result++;
//            return;
//        }
//        if (target < curSum) {
//            return;
//        }
//
//        for (int i = curIndex; i < array.length; i++) {
//            helper(array, target, curSum+array[i], startIndex, i);
//        }
//    }
}
