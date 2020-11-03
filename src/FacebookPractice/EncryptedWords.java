package FacebookPractice;

public class EncryptedWords {
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) {
        System.out.println(findEncryptedWord("abcd"));
    }
    static boolean encryptString(String s) {
        if (s.length() < 3) {
            sb.append(s);
            return false;
        }
        int middleIndex = s.length()/2;
        if (s.length() %2 == 0) {
            middleIndex = middleIndex-1;
        }
        sb.append(s.charAt(middleIndex));
        encryptString(s.substring(0, middleIndex));
        encryptString(s.substring(middleIndex+1, s.length()));
        return true;
    }

    static String findEncryptedWord(String s) {
        // Write your code here
        // abcd
        int middleIndex = s.length()/2;
        if (s.length() %2 == 0) {
            middleIndex = middleIndex-1;
        }
        sb.append(s.charAt(middleIndex));
        encryptString(s.substring(0, middleIndex));
        encryptString(s.substring(middleIndex+1, s.length()));
        return sb.toString();
    }
}
