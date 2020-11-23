package Amazon;
import java.util.*;

public class EarliestTimeToCompleteDelivery {
    public static void main(String args[]) {
        int numOfBuildings = 2;
//        int [] buildingopenTime = {8, 10};
//        int [] offloadTime = {2, 2, 3, 1, 8, 7, 4, 5};
        int [] buildingopenTime = {8, 10};
        int [] offloadTime = {6,6,6,6,5,5,5,5};
        System.out.println(getResult(numOfBuildings, buildingopenTime, offloadTime));
    }

    public static int getResult(int numOfBuildings, int [] buildingopenTime, int [] offloadTime) {
        Arrays.sort(buildingopenTime); // sort by increasing order

        // Max PQ
        PriorityQueue<Integer> offloadingItems = new PriorityQueue<Integer>((i, j) -> j-i);
        for (int i = 0; i < offloadTime.length; i++) {
            offloadingItems.add(offloadTime[i]);
        }

        Map<Integer, Integer> offloadedCount = new HashMap<>(); // key: idx of building, value: offloaded items count
        for (int i = 0; i < buildingopenTime.length; i++) {
            offloadedCount.put(i, 0);
        }

        int curOffloadingItem = offloadingItems.remove();
        int maxTime = buildingopenTime[0] + curOffloadingItem;
        offloadedCount.put(0, 1);

        int buildingIndex = 0;
        while (!offloadingItems.isEmpty()) {
            if (offloadedCount.get(buildingIndex) >= 4) {
                buildingIndex++;
                continue;
            }

            curOffloadingItem = offloadingItems.remove();
            maxTime = Math.max(maxTime, buildingopenTime[buildingIndex] + curOffloadingItem);

            offloadedCount.put(buildingIndex, offloadedCount.get(buildingIndex) + 1);
        }

        return maxTime;
    }
}
