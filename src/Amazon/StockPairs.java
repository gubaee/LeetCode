package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class StockPairs {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(7);
        arrList.add(9);
        arrList.add(13);
        arrList.add(11);
        arrList.add(6);
        arrList.add(6);
        arrList.add(3);
        arrList.add(3);

        System.out.println(stockPairs(9, arrList, 12));
    }
    // 3 3 5 6 6 7 9 11 13
    static int count = 0;
    static int curSum = 0;
    static int tempCount = 0;
    public static int stockPairs(int num, ArrayList<Integer> stocksProfit, int target) {
        Collections.sort(stocksProfit);
        int unique = 0;
        HashMap<Integer, Integer> stockMap = new HashMap<>();
        for (int i = 0 ; i < stocksProfit.size(); i++) {
            stockMap.put(stocksProfit.get(i), 0);
        }
        for (int i = 0 ; i < stocksProfit.size(); i++) {
            if (stockMap.containsKey(target-stocksProfit.get(i))) {
                int num1 = target-stocksProfit.get(i);
                int num2 = stocksProfit.get(i);
                stockMap.put(Math.min(target-stocksProfit.get(i), stocksProfit.get(i)), 1);
            }
        }
        for (Map.Entry<Integer, Integer>  entry: stockMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("true");

                unique++;
            }
        }
        return unique;
    }
}
