package Medium;
import java.util.*;

public class LettersCombinationOfPhoneNumbers {
    public static void main(String args[]) {
        List<String> list = letterCombinations("23");


    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> numMap = new HashMap<>();
        generateMap(numMap);
        //2345
        List<String> result = new ArrayList<>();

        dfs(new StringBuilder(), digits, result, numMap);
        return result;
    }


    public static void dfs(StringBuilder sb, String nextDigits, List<String> result,
                           Map<Character, String> numMap) {
        if (nextDigits.length() == 0) {
            result.add(sb.toString());
            return ;
        }

        String digit = nextDigits.substring(0, 1);
        String letters = numMap.get(digit.charAt(0));

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(sb, nextDigits.substring(1), result, numMap);
            sb.deleteCharAt(sb.length()-1);
        }
    }

//    public static void dfs(String combination, String nextDigits, List<String> result,
//                           Map<Character, String> numMap) {
//        if (nextDigits.length() == 0) {
//            result.add(combination);
//            return ;
//        }
//
//        String digit = nextDigits.substring(0, 1);
//        String letters = numMap.get(digit);
//
//        for (int i = 0; i < letters.length(); i++) {
//
//        }
//    }


    public static void generateMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
