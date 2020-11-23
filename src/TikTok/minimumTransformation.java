package TikTok;
import java.util.*;

public class minimumTransformation {
    // DOES NOT WORK
    // DOES NOT WORK
    // DOES NOT WORK
    // DOES NOT WORK

    public static void main(String args[]) {

    }
    public static int getMinTransform(String source, String target) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++) {
            if(!map.containsKey(source.charAt(i))) {
                map.put(source.charAt(i), target.charAt(i));
            } else {
                char cur = source.charAt(i);
                char value = map.get(source.charAt(i));
                if (map.get(value) == cur) {
                    // found a cycle
                    return -1;
                }
                if(map.get(source.charAt(i)) != target.charAt(i)) {
                    return -1;
                }
            }
        }
        return 1;
    }
    private static boolean possible(String source, String target) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++) {
            if(!map.containsKey(source.charAt(i))) {
                map.put(source.charAt(i), target.charAt(i));
            } else {
                char cur = source.charAt(i);
                char value = map.get(source.charAt(i));
                if (map.get(value) == cur) {
                    // found a cycle
                    return false;
                }
                if(map.get(source.charAt(i)) != target.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
