package Easy;
import java.util.*;

public class BaseballGame {
    public static void main(String args[]) {
        String [] array = {"5","-2","4","C","D","9","+","+"};

        System.out.println(Integer.valueOf("-2"));
        System.out.println(calPoints(array));
    }

    //[5, -2, -4, 9, 5, 14].
    public static int calPoints(String[] ops) {
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].charAt(0) == '+') {
                int first = scores.get(scores.size()-2);
                int second = scores.get(scores.size()-1);
                scores.add(first + second);
            } else if (ops[i].charAt(0) == 'C') {
                scores.remove(scores.size()-1);
            } else if (ops[i].charAt(0) == 'D') {
                scores.add(scores.get(scores.size()-1) * 2);
            } else {
                scores.add(Integer.valueOf(ops[i]));
            }
        }
        int result = 0;
        for (int i = 0; i < scores.size(); i++) {
            result += scores.get(i);
        }

        return result;
    }
}
