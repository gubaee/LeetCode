package Medium;
import java.util.*;

public class TopKFrequentWord {
    public static class Word {
        String word;
        int frequency;
        public Word(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
    public static void main(String args[]) {
        String [] array = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(array, 2);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Word> maxHeap = new PriorityQueue<Word>((i, j) -> {
            if (j.frequency == i.frequency) {
                return i.word.compareTo(j.word);
            }
            return j.frequency-i.frequency;
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            Word word = new Word(e.getKey(), e.getValue());
            maxHeap.add(word);
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(maxHeap.remove().word);
        }



        return result;
    }
}
