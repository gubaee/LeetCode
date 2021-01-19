package Medium;
import java.util.*;

public class StringCompression {
    public static void main(String args[]) {
        char chars [] = {'a','a','b','b','c','c'};
        compress(chars);
    }
    public static int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {

            char curChar = chars[i];
            int count = 0;
            chars[index] = curChar;
            index++;

            while (i < chars.length && chars[i] == curChar) {
                count++;
                i++;
            }
            if (count > 1) {
                for (char c: String.valueOf(count).toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }
        }

        return chars.length;
    }
}
