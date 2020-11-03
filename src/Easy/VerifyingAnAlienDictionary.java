package Easy;
import java.util.*;
public class VerifyingAnAlienDictionary {
    public static void main(String args[]) {
        String[] array = {"apap", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(array, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length; i++) {
            wordList.add(words[i]);
        }


        for (int i = 0; i < wordList.size()-1; i++) {
            String first = wordList.get(i);
            String second = wordList.get(i+1);
            int stringIndex = 0;
            if (orderMap.get(first.charAt(stringIndex)) < orderMap.get(second.charAt(stringIndex))) {
                continue;
            } else if (orderMap.get(first.charAt(stringIndex)) > orderMap.get(second.charAt(stringIndex))) {
                return false;
            } else {
                int length = Math.min(first.length(), second.length());
                boolean toNext = false;
                for (int j = 0; j < length; j++) {
                    if (orderMap.get(first.charAt(j)) < orderMap.get(second.charAt(j))) {
                        toNext = true;
                        break;
                    } else if (orderMap.get(first.charAt(j)) == orderMap.get(second.charAt(j))){
                        continue;
                    } else {
                        return false;
                    }
                }
                if (toNext == false) {
                    if (first.length() > second.length()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
