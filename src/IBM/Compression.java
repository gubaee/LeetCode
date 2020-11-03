package IBM;

public class Compression {
    public static void main(String args[]) {
        System.out.println(compressedString("aaabaaaaccaaaaba"));
    }
    public static String compressedString(String message) {
        if (message.length() <= 1) {
            return message;
        }
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (index < message.length()) {
            int start = index;
            int count = 0;
            char ch = message.charAt(start);
            while (start < message.length() && ch == message.charAt(start)) {
                start++;
                count++;
            }
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
                index = index + count;
            } else {
                index ++;
            }
        }

        return sb.toString();
    }
}
