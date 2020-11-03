package Medium;
import java.util.*;
public class BasicCalculator {
    public static void main(String args[]) {
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {

            if(isMultipleOrDivision(s.charAt(i))) {
                int left = i;
                int right = i;
                while(left > 0 && isNum(s.charAt(left-1))) {
                    left--;
                }
                while(right < s.length()-1 && isNum(s.charAt(right+1))) {
                    right++;
                }
                String leftValue = s.substring(left, i);
                String rightValue = s.substring(i+1, right+1);

                int leftNum = Integer.valueOf(leftValue);
                int rightNum = Integer.valueOf(rightValue);
                int resultVal = 0;
                if (isMultiple(s.charAt(i))) {
                    resultVal = leftNum * rightNum;
                }
                if (isDivision(s.charAt(i))) {
                    resultVal = leftNum / rightNum;
                }
                sb.replace(left, right+1, Integer.toString(resultVal));
                i = left;
                s = sb.toString();
            }

        }
        String temp = sb.toString();
        if (temp.length() == 1) {
            return Integer.valueOf(temp);
        }
        sb = new StringBuilder();
        int right = 0;
        int left = 0;
        int result = 0;
        int num = 0;
        boolean addition = true;
        while (right < temp.length()) {
            if (isNum(temp.charAt(right))) {
                right++;
            } else {
                num = Integer.valueOf(temp.substring(left, right));
                left = right+1;

                if (addition) {
                    result += num;
                } else {
                    result -= num;
                }
                if (isAddition(temp.charAt(right))) {
                    addition = true;
                } else {
                    addition = false;
                }
                right++;
            }
        }
        num = Integer.valueOf(temp.substring(left, right));
        if (addition) {
            result += num;
        } else {
            result -= num;
        }
        return result;
    }
    public static boolean isMultipleOrDivision(char ch) {
        return isMultiple(ch) || isDivision(ch);
    }
    public static boolean isNum(char ch) {
        if (ch-'0' >= 0 && ch-'0' < 10) {
            return true;
        }
        return false;
    }
    public static boolean isMultiple(char ch) {
        return ch == '*';
    }
    public static boolean isDivision(char ch) {
        return ch == '/';
    }
    public static boolean isAddition(char ch) {
        return ch == '+';
    }
    public static boolean isSubtraction(char ch) {
        return ch == '-';
    }
}
