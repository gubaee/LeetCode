package FacebookPractice;
import java.util.*;

public class RotationalCipher {
    public static void main(String args[]) {
        String input = "All-convoYs-9-be:Alert1.";
        System.out.println(rotationalCipher(input, 4));
    }
    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            char charAfterRotation = input.charAt(i);
            int asciiNum = curChar + rotationFactor;
            if (isNumber(curChar)) {
                int modNum = 10;
                asciiNum -= '0';
                charAfterRotation = (char) ( (asciiNum % modNum) + '0');
            } else if (isLowerAlphabet(curChar)) {
                int modNum = 26;
                asciiNum -= 'a';
                charAfterRotation = (char) ( (asciiNum % modNum) + 'a');

            } else if (isBigAlphabet(curChar)) {
                int modNum = 26;
                asciiNum -= 'A';
                charAfterRotation = (char) ( (asciiNum % modNum) + 'A');
            }
            sb.append(charAfterRotation);
        }
        return sb.toString();
    }
    static boolean isNumber(char ch) {
        if (ch - '0' >= 0 && ch - '0' < 10) {
            return true;
        }
        return false;
    }
    static boolean isLowerAlphabet(char ch) {
        if (ch - 'a' >= 0 && ch - 'a' < 26) {
            return true;
        }
        return false;
    }
    static boolean isBigAlphabet(char ch) {
        if (ch - 'A' >= 0 && ch - 'A' < 26) {
            return true;
        }
        return false;
    }
}
