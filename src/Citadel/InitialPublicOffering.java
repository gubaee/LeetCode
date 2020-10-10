package Citadel;

import java.util.*;

public class InitialPublicOffering {
    // <user Id, number of shares, bidding price, timestamp>
    public static void main(String args[]) {
        List<List<Integer>> bids = setUp();
        int totalShares = 3;

        List<Integer> result = getUnallottedUsers(bids, totalShares);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
        Collections.sort(bids, (l1, l2) -> {
            int comparePriceResult = l2.get(2) - l1.get(2); // sort by high num
            if (comparePriceResult < 0) {
                return -1;
            } else if (comparePriceResult > 0) {
                return 1;
            } else {
                int compareTimestampResult = l1.get(3) - l2.get(3); // sort by low num
                if (compareTimestampResult < 0) {
                    return -1;
                } else if (compareTimestampResult > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // contains key as a targetPrice, and value with the index
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < bids.size(); i++) {
            ArrayList<Integer> curBid = (ArrayList<Integer>)bids.get(i);
            int price = curBid.get(2);
            if (map.get(price) == null) {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i); // add the current index
                map.put(price, indices);
            } else {
                ArrayList<Integer> indices = map.get(price);
                indices.add(i);
            }
        }

        int i = 0;
        ArrayList<Boolean> gotAShare = new ArrayList<Boolean>();
        for (int j = 0; j < bids.size(); j++) {
            gotAShare.add(false);
        }
        while (totalShares > 0 && i < bids.size()) {
            int currentPrice = bids.get(i).get(2);
            int sameSizeCount = map.get(currentPrice).size();
            if (sameSizeCount == 1) {
                int numOfShares = bids.get(i).get(1);
                totalShares = totalShares - numOfShares;
                bids.remove(i);
            } else {
                int start = i;
                int end = start + sameSizeCount-1;
                int pointer = start;
                while (totalShares > 0) {

                    int amountOfSharesLeft = bids.get(pointer).get(1); // shares left to buy at that index
                    if (amountOfSharesLeft > 0) {
                        gotAShare.set(pointer, true);
                        amountOfSharesLeft -= 1;
                        bids.get(pointer).set(1, amountOfSharesLeft); // decrement 1
                        totalShares = totalShares - 1;
                        if (amountOfSharesLeft == 0) {
                            bids.remove(pointer);
                            gotAShare.remove(pointer);
                            continue;
                        }
                    } else {
                        gotAShare.set(pointer, true);
                        gotAShare.remove(pointer);
                        bids.remove(pointer); // since we removed, pointer don't need to be incremented
                        end = end - 1; // since we removed, end of the index has to be decremented too
                        continue;
                    }
                    if (pointer < end) {
                        pointer ++;
                    } else {
                        pointer = start;
                    }
                }
                if (totalShares == 0) {
                    break;
                }
                i = i + sameSizeCount-1;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int j = 0; j < bids.size(); j++) {
            if (gotAShare.get(j) == true) {
                continue;
            }
            int currentUserId = bids.get(j).get(0);
            result.add(currentUserId);
        }
        return result;
    }

    public static List<List<Integer>> setUp() {
        List<List<Integer>> bids = new ArrayList<>();
        ArrayList<Integer> bid1 = new ArrayList<Integer>();
        bid1.add(1);
        bid1.add(2); // shares it needs
        bid1.add(5); // price
        bid1.add(0);

        ArrayList<Integer> bid2 = new ArrayList<Integer>();
        bid2.add(2);
        bid2.add(1);
        bid2.add(4);
        bid2.add(2);

        ArrayList<Integer> bid3 = new ArrayList<Integer>();
        bid3.add(3);
        bid3.add(5);
        bid3.add(4);
        bid3.add(6);

//        ArrayList<Integer> bid4 = new ArrayList<Integer>();
//        bid4.add(4);
//        bid4.add(10);
//        bid4.add(3);
//        bid4.add(3);
//
        bids.add(bid1);
        bids.add(bid2);
        bids.add(bid3);
//        bids.add(bid4);

        return bids;
    }

}
