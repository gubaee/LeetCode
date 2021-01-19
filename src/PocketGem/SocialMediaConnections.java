package PocketGem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SocialMediaConnections {
    public static void main(String[] args) {
        System.out.println(bestTrio(5, Arrays.asList(1, 2, 2, 3, 4, 5), Arrays.asList(2, 4, 5, 5, 5, 6)));
    }
    public static int bestTrio(int friendNodes, List<Integer> friendsFrom, List<Integer> friendsTo) {
        HashMap<Integer, HashSet<Integer>> visitedNodes = new HashMap<>();
        ArrayList<int[]> trios = new ArrayList<>();
        ArrayList<Integer> numFriends = new ArrayList<>();

        for (int i = 0; i < friendsFrom.size(); i++) {
            int to = friendsTo.get(i);
            int from = friendsFrom.get(i);
            HashSet fromSet = visitedNodes.getOrDefault(from, new HashSet<Integer>()); // Grabs current list of nodes adjacent to current node
            fromSet.add(to); // Add adjacent node to the current node list
            visitedNodes.put(from, fromSet); // Updates list of adjacent nodes to the current node
            HashSet toSet = visitedNodes.getOrDefault(to, new HashSet<Integer>()); // Grabs list for adjacent node
            toSet.add(from); // Adds current node to the adjacent node list
            visitedNodes.put(to, toSet); // Updates adjacent node's list to add current node
            Iterator<Integer> itr = fromSet.iterator();
            while (itr.hasNext()) {
                int next = itr.next();
                if (toSet.contains(next)) {
                    trios.add(new int[] {from, to, next});
                }
            }
        }

        // un comment this and remove while loop and line 54 ~ end;
//        int min = Integer.MAX_VALUE;

        for (int[] trio : trios) {
            int friends = 0;
            for (int k = 0; k < 3; k++) {
                Iterator<Integer> itr = visitedNodes.get(trio[k]).iterator();
                while (itr.hasNext()) {
                    int next = itr.next();
                    if (next != trio[0] && next != trio[1] && next != trio[2]) {
                        friends++;
                    }
                }
                // friends += itr.size()-2;
            }
//            min = Math.min(friends, min);
            numFriends.add(friends);
        }
        int minFriends = Integer.MAX_VALUE;
        for (Integer friends : numFriends) {
            if (friends < minFriends) {
                minFriends = friends;
            }
        }
        return minFriends;
    }

}