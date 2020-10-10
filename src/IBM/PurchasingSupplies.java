package IBM;

import java.util.ArrayList;
import java.util.List;

public class PurchasingSupplies {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("10 2 5");
        list.add("12 4 4");
        list.add("6 2 2");
        maximumContainers(list);
    }
    public static void maximumContainers(List<String> scenarios) {
        // Write your code here
        for (int i = 0; i < scenarios.size(); i++) {
            String scenario = scenarios.get(i);
            String [] eachData = scenario.split(" ");

            int budget = Integer.valueOf(eachData[0]);
            int cost = Integer.valueOf(eachData[1]);
            int freeTradingCost = Integer.valueOf(eachData[2]);
            int totalContainers = 0;
            int leftOverContainers = 0;

            while (true) {
                // 4 1 2
                int containersCount = buyWithBudget(budget, cost);
                totalContainers += containersCount;

                budget = leftOverBudget(budget, cost);

                int availableContainers = containersCount + leftOverContainers;

                int tradedContainerCount = buyWithEmptyContainer(
                        availableContainers,
                        freeTradingCost
                );

                int remainderAfterTrade = tradedContainerCount + leftOverContainer(availableContainers, freeTradingCost);

                totalContainers += tradedContainerCount;

                leftOverContainers = remainderAfterTrade;
                if (budget < cost && leftOverContainers < freeTradingCost) {
                    break;
                }

            }
            System.out.println(totalContainers);
        }
    }
    // return the total number of containers you can buy with budget
    public static int buyWithBudget(int budget, int cost) {
        if (budget == 0) {
            return 0;
        }
        return budget / cost;
    }
    // return the remainder of budget after buying container
    public static int leftOverBudget(int budget, int cost) {
        return budget % cost;
    }
    // return the total number of containers you can trade with emptyContainers
    public static int buyWithEmptyContainer(int emptyContainers, int freeTradingCost) {
        if (emptyContainers == 0) {
            return 0;
        }
        return emptyContainers / freeTradingCost;
    }
    // return the remainder of empty Containders after trading
    public static int leftOverContainer(int emptyContainers, int freeTradingCost) {
        // 4 , 1
        if (emptyContainers == freeTradingCost) {
            return 0;
        }
        return emptyContainers % freeTradingCost;
    }

}
