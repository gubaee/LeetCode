package Amazon;
import java.util.*;

public class SearchSuggestionsSystem {
    public static void main(String args[]) {
        String [] products = {"mobile", "moneypot", "monitor", "mouse", "mousepad"};
        String searchWord = "mouse";
//        String [] products = {"bags","baggage","banner","box","cloths"};
//        String searchWord = "bags";
        suggestedProducts(products, searchWord);
    }

    public static List<List<String>> suggestedProducts(String [] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> subResult = new ArrayList<>();

            for (int j = 0; j < products.length && subResult.size() < 3; j++) {
                if (products[j].length() >= i && products[j].substring(0, i).equals(searchWord.substring(0, i))) {
                    subResult.add(products[j]);
                }
            }

            result.add(subResult);
        }
        return result;
    }
}
