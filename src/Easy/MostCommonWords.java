package Easy;
import java.util.*;

public class MostCommonWords {
    public static void main(String args[]) {
        String array [] = {"bob", "hit"};
        System.out.println(mostCommonWord("Bob. hIt, baLl", array));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
        paragraph = paragraph.toLowerCase();

        String [] words = paragraph.split("\\s+");
        String [] words2 = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedList = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedList.add(banned[i]);
        }

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                if (!bannedList.contains(words[i])) {
                    map.put(words[i], 1);
                }
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>( (i, j) -> {
            return j.getValue()-i.getValue();
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        return pq.remove().getKey();
    }
}
