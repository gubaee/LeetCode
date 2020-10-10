package Medium;

import java.util.*;

public class GenerateParentheses {
    public static void main(String args[]) {
        System.out.println(generateParenthesis(6));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        permutate(result, "", 0, 0, n);

        return result;
    }

    public static void permutate(List<String> list, String currentStr, int open, int close, int max) {
        if (currentStr.length() == max*2) {
            list.add(currentStr);
        }

        if (open < max) {
            permutate(list, currentStr, open+1, close, max);
        }
        if (close < open) {
            permutate(list, currentStr, open, close+1, max);
        }
    }
}
