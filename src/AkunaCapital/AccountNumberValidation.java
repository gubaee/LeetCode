package AkunaCapital;

import java.util.Queue;

public class AccountNumberValidation {

    public static void main(String args[]) {
        String word = "BADF00D5";
        String word2 = "1CC0FfEE";
        String word3 = "CAFEDOOD";
        String word4 = "0000";
        System.out.println(validateAccountNumber(word));
        System.out.println(validateAccountNumber(word2));
        System.out.println(validateAccountNumber(word3));
        System.out.println(validateAccountNumber(word4));
    }
    public static String validateAccountNumber(String accountNumber) {
        int sum = getDecimalSum(accountNumber.substring(2, accountNumber.length()));
        if (accountNumber.length() != 8) {
            return "INVALID";
        }
        if (sum == -1) {
            return "INVALID";
        }
        String originalChecksum = accountNumber.substring(0, 2);
        String resultChecksum = Integer.toHexString(sum);

        if (originalChecksum.equals("00") && resultChecksum.equals("0")) {
            return "VALID";
        }
        return validateChecksum(originalChecksum, resultChecksum);
    }

    public static String validateChecksum(String originalChecksum, String resultChecksum) {
        return originalChecksum.equalsIgnoreCase(resultChecksum) ? "VALID" : "INVALID";
    }

    public static int getDecimalSum(String hex) {
        hex = hex.toLowerCase();
        for (int i = 0; i < hex.length(); i++) {
            int asciiVal = hex.charAt(i)-'a';
            if (asciiVal < 0 || asciiVal > 5) {
                //it is not between a ~ f
                // check whether they are int
                asciiVal = hex.charAt(i)-'0';
                if (asciiVal < 0 || asciiVal > 9) {
                    return -1;
                }
            }
        }
        int decimal = Integer.parseInt(hex, 16);
        int sum = 0;
        int remainder = 0;
        while (decimal > 0) {
            remainder = decimal % 10;
            decimal = decimal / 10;
            sum = sum + remainder;
        }
        return sum;
    }
}
