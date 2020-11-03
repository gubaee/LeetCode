package Hard;

import java.util.*;


public class minWindow {

    public static void main(String args[]) {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println();
    }
    public static String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int smallest = Integer.MAX_VALUE;
        int missing = t.length();

        int [] array = new int [128];
        for (int i = 0 ; i < t.length(); i++) {
            array[t.charAt(i)]++;
        }

        while (right < s.length()) {
            if (array[s.charAt(right)]>0) {
                missing--;
            }

            array[s.charAt(right)]--;
            right++;

            while(missing == 0) {
                int curWindowSize = right-left;
                if(end == 0 || smallest > curWindowSize){
                    start = left;
                    end = right;
                    smallest = end - start;
                }
                array[s.charAt(left)]++;
                if (array[s.charAt(left)] > 0) {
                    missing++;
                }
                left++;
            }
        }
        return s.substring(start, end);
    }
}
