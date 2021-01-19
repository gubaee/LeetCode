package Snowflake;

import java.util.ArrayList;
import java.util.List;

public class largestArea {
    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
//        list1.add(1);
//        list1.add(1);
//        list1.add(1);
//        list2.add(1);
//        list2.add(1);
//        list2.add(0);
//        list3.add(1);
//        list3.add(0);
//        list3.add(1);

        // 1 1 1
        // 1 1 0
        // 1 0 1

        // 0 0 0 0
        // 0 1 1 1
        // 0 1 2 0
        // 0 1 0

//        list1.add(0);
//        list1.add(0);
//        list1.add(0);
//        list2.add(0);
//        list2.add(0);
//        list2.add(0);
//        list3.add(0);
//        list3.add(0);
//        list3.add(0);

        List<List<Integer>> sample = new ArrayList<>();
        sample.add(list1);
        sample.add(list2);
        sample.add(list3);
        System.out.println(largestArea(sample));

    }

//    public static int largestArea(List<List<Integer>> sample) {
//        if (sample.size() == 0) {
//            return 0;
//        }
//
//        int [][] dp = new int [sample.size()][sample.get(0).size()];
//        int max = 0;
//
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 0;
//            dp[0][i] = 0;
//        }
//
//        for (int i = 1; i < sample.size(); i++) {
//            for (int j = 1; j < sample.get(0).size(); j++) {
//                if (sample.get(i-1).get(j-1) == 1) {
//                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
//                }
//                if (max < dp[i][j]) {
//                    max = dp[i][j];
//                }
//            }
//        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + ", ");
//            }
//            System.out.println();
//        }
//        return max;
//    }
    public static int largestArea(List<List<Integer>> sample) {
        if (sample.size() == 0) {
            return 0;
        }

        int [][] dp = new int [sample.size()][sample.get(0).size()];
        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            if (sample.get(i).get(0) == 1) {
                max = 1;
            } else if (sample.get(0).get(i) == 1) {
                max = 1;
            }
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (sample.get(i-1).get(j-1) == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
