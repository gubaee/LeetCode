package Easy;

public class ReverseBinaryOfInteger {
    public static void main(String args[]) {
        System.out.println(reverse(8));
    }

    public static String reverse(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int result = num&1;
            sb.append(result);
            num /= 2;
        }
        System.out.println(Integer.valueOf(sb.toString()));
        return sb.toString();
    }
}
