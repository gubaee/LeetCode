package Easy;
import java.math.BigInteger;
import java.util.*;
public class findFactors {
    public static void main(String args[]) {
        // 68238256
        List<Integer> result = getFactorsQ7(68238256);
        Collections.sort(result);
        printResult(result);
        System.out.println();



        System.out.println("===========Question 4 ==========");
        String [] resultQ4 = solveQ4A();
        printResultQ4(resultQ4);
        System.out.println();

        System.out.println("===========Question 9 ==========");
        String n = "68254939";
        String message = "22334455";
        int e = 3;
        System.out.println(solveQ9(message, e, n));
        String c = "59646586"; // 55443322
        int d = 45492171;
        System.out.println("===========Question 10 ==========");
        System.out.println(solveQ10(c, d, n));

        System.out.println("===========Question 11 ==========");
        n = "68254939";
        String decrypt = "55443322";
        e = 3;
        d = 45492171;
        System.out.println(solveQ10(decrypt, d, n));
        String p = "39260108";
        System.out.println("===========Question 12 ==========");
        System.out.println(solveQ10(p, e, n));

    }

    public static List<Integer> getFactorsQ7(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num%i == 0) {
                result.add(i);
                result.add(num/i);
            }
        }
        return result;
    }

    public static void printResult(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println();
    }
    public static void printResultQ4(String [] result) {
        for (int i = 0; i < result.length; i++) {
            int num = Integer.valueOf(result[i]);
            char ch = (char) (num + 'A' - 1);
//            System.out.println(result[i] + " = " + ch);
            System.out.print(ch);
        }
        System.out.println();
    }

    public static String [] solveQ4A() {
        String [] arrayQ4 = "1 12 3 27 26 1 5 31 8 9 8 27 9 19 19 21 5 3 27 1 14 26 28 26 27 21 24 26 12 16 23 17 3 12 26 28 9 27 3 1 12 31 3 28 14 1 5 27 3 5 13".split(" ");
        int d = 7;
        long phi = 33;
        String [] result = new String [arrayQ4.length];
        // p = 11, q = 3, n = 33, e = 3, phi = 20
        // num^d mod phi
        for (int i = 0; i < arrayQ4.length; i++) {
            long num = Long.valueOf(arrayQ4[i]);
            num = (long) Math.pow(num, d);
            result[i] = Long.toString(num%phi);
        }

        return result;
    }

    public static String [] solveQ4B() {
        String [] arrayQ4 = "1 12 3 27 26 1 5 31 8 9 8 27 9 19 19 21 5 3 27 1 14 26 28 26 27 21 24 26 12 16 23 17 3 12 26 28 9 27 3 1 12 31 3 28 14 1 5 27 3 5 13".split(" ");
        int d = 7;
        int phi = 20;
        String [] result = new String [arrayQ4.length];
        // p = 11, q = 3, n = 33, e = 3, phi = 20
        // num^d mod phi
        for (int i = 0; i < arrayQ4.length; i++) {
            long num = Long.valueOf(arrayQ4[i]);
            for (int j = 0; j < d; j++) {
                num = (num * num) % phi;
            }
            result[i] = Long.toString(num % phi);
        }

        return result;
    }

    public static long solveQ9(String message, int e, String n) {
        // phi = 68238256
        // e = 3
        // message = 22334455
        BigInteger m = new BigInteger(message);
        BigInteger result = new BigInteger(message);
        BigInteger ph = new BigInteger(n);
        for (int i = 0; i < e-1; i++) {
            result = result.multiply(m);
            result = result.mod(ph);
        }
        result = result.mod(ph);
        return result.longValue();
    }

    public static int solveQ10(String c, int d, String n) {
        // phi = 68238256
        // d = 45492171
        // c(encrypted message) = 19320993
        BigInteger m = new BigInteger(c);
        BigInteger result = new BigInteger(c);
        BigInteger ph = new BigInteger(n);
        for (int i = 0; i < d-1; i++) {
            result = result.multiply(m);
            result = result.mod(ph);
        }
        result = result.mod(ph);
        return result.intValue();
    }



}
