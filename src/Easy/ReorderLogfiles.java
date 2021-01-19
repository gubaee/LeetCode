package Easy;
import java.util.*;

public class ReorderLogfiles {
    public static void main(String args[]) {

    }
    public String[] reorderLogFiles(String[] logs) {
        Queue<String> digits = new LinkedList<>();
        PriorityQueue<String> letters = new PriorityQueue<String>((i, j) -> {
            String one = i.substring(i.indexOf(" "), i.length());
            String two = j.substring(j.indexOf(" "), j.length());

            return two.compareTo(one);
        });

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].charAt(0) == 'l') {
                letters.add(logs[i]);
            } else {
                digits.add(logs[i]);
            }
        }

        for (int i = 0; i < logs.length; i++) {
            if (!letters.isEmpty()) {
                logs[i] = letters.remove();
            } else {
                logs[i] = digits.remove();
            }
        }
        return logs;
    }
}
