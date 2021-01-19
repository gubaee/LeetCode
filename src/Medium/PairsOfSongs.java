package Medium;
import java.util.*;

public class PairsOfSongs {
    public static void main(String args[]) {
        int [] array = {30,20,150,100,40};
        numPairsDivisibleBy60(array);
    }
    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}
