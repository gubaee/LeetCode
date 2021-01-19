package Medium;
import java.util.*;

public class TaskSchedular {
    public static void main(String args[]) {
        char [] tasks = {'A','A','A','G'};
//        char [] tasks = {'A','A','A','B','B','B','C','C'};
        leastInterval(tasks, 2);
    }

    public static int leastInterval(char[] tasks, int n) {
        int [] freq = new int [26];

        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i]-'A']++;
        }

        Arrays.sort(freq);

        int emptySpace = (freq[25]-1) * n;

        for (int i = freq.length-2; i >= 0 && emptySpace > 0; i --) {
            emptySpace -= Math.min(freq[25]-1, freq[i]);
        }
        // A G 0 A 0 0 A

        return emptySpace + tasks.length;
    }
}
