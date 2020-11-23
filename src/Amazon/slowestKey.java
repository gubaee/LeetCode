package Amazon;
import java.util.*;

public class slowestKey {
    public static void main(String args[]) {
        int[] releaseTimes = {23, 34, 43, 59, 62, 80, 83, 92, 97};
        String keysPressed = "qgkzzihfc";
        System.out.println(slowestKey(releaseTimes, keysPressed));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int [] durations = new int [26];
        durations[keysPressed.charAt(0)-'a'] = releaseTimes[0];
        int max = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int index = keysPressed.charAt(i)-'a';
            int duration = releaseTimes[i] - releaseTimes[i-1];

            durations[index] = Math.max(durations[index], duration);
            max = Math.max(max, durations[index]);
        }

        char result = ' ';
        for (int i = durations.length-1; i >= 0; i--) {
            if (durations[i] == max) {
                result = (char) (i + 'a');
                break;
            }
        }

        return result;
    }
}
