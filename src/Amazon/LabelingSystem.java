package Amazon;
import java.util.*;

public class LabelingSystem {
    public static void main(String args[]) {
        System.out.println(getResult(2, "baccbbcccc"));
    }
    public static String getResult(int charLimit, String originalLabel) {
        // priority queue that keeps track of biggest char
        PriorityQueue<Character> pq = new PriorityQueue<>((i, j) -> j-i);

        // Map that keeps track of chars and count in original label
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < originalLabel.length(); i++) {
            char ch = originalLabel.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                pq.add(ch);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        // once it reaches same length, we are done

        Character [] oLabel = new Character[originalLabel.length()];
        for (int i = 0; i < originalLabel.length(); i++) {
            oLabel[i] = originalLabel.charAt(i);
        }
        Arrays.sort(oLabel, (i, j) -> j-i);

        int curCount = charLimit;
//        char curChar = pq.remove();
        while (sb.length() < oLabel.length) {
            char curChar = pq.peek();
            // if it didn't reach limit, just simply append and update map
            if (curCount > 0) {
                sb.append(curChar);
                curCount--;
                map.put(curChar, map.get(curChar)-1);

                if (map.get(curChar) == 0) { // delete if no more chars left to add
                    map.remove(curChar);
                    curCount = charLimit;
                    pq.remove();
                    continue;
                }

            } else { // if it reached limit, append next char
                char temp = curChar;
                pq.remove();
                char nextChar = pq.peek();
                sb.append(nextChar);
                map.put(nextChar, map.get(nextChar)-1);

                if (map.get(nextChar) == 0) { // delete if no more chars left to add
                    map.remove(nextChar);
                    pq.remove();
                }
                curCount = charLimit;
                pq.add(temp);

            }
        }
        return sb.toString();
    }
}
