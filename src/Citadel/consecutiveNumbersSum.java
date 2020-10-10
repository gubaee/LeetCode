package Citadel;

public class consecutiveNumbersSum {
    // https://leetcode.com/problems/consecutive-numbers-sum/?fbclid=IwAR0O5JBElSSJMK3BY7VuCEzBdx3_8JXRglL1FwOHrfoXGf7IftVx65GIWtI
    public static void main(String args[]) {

    }
    public int consecutiveNumbersSum(int num) {
        int count = 0;
        long upper_limit = (long)(Math.sqrt(2 * num + 0.25) - 0.5);
        for (long k = 1; k <= upper_limit; ++k) {
            num -= k;
            if (num % k == 0)
                count++;
        }
        return count-1;
    }

}
