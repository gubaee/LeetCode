package Medium;
import java.util.*;

public class removeDuplicate {
    public static void main(String args[]) {
        System.out.println(removeDuplicates("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz", 5));
    }
    public static String removeDuplicates(String s, int k) {
        // int count = 0;
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        while(true) {
            int removedCount = 0;
            while (pointer < s.length()) {
                char curChar = s.charAt(pointer);

                int count = 0;

                while (pointer < s.length() && s.charAt(pointer) == curChar) {
                    count++;
                    pointer++;
                    if (count == k) {
                        break;
                    }
                }
                if (count != k) {
                    for (int i = 0; i < count; i++) {
                        sb.append(curChar);
                    }
                } else {
                    removedCount ++;
                }
            }
            if (removedCount == 0) {
                break;
            }
            s = sb.toString();
            sb = new StringBuilder();
            pointer = 0;
        }
        return sb.toString();
    }
}
