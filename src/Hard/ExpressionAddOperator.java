package Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    static StringBuilder sb = new StringBuilder();

    static int result = 0;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        dfs(0, "13", 0, 2, "", list);

        System.out.println(result);
    }

    private static void dfs(int index, String input, int num, int k, String curString, List<String> list) {
        if (index == input.length()) {
            if (num == k) {
                result++;
                list.add(curString.toString());
            }
            return;
        }

        int currDigit = input.charAt(index) - '0';
        sb = new StringBuilder(curString);
        sb.append("+");
        sb.append(currDigit);
        dfs(index+1, input, num + currDigit, k, sb.toString(), list);

        sb = new StringBuilder(curString);
        sb.append("-");
        sb.append(currDigit);
        dfs(index+1, input, num - currDigit, k, sb.toString(), list);
    }
}
