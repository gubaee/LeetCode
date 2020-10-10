package Cisco;

import java.util.Scanner;

import static Medium.rotateImage.rotate;

public class maxDifference {
    public static void main(String args[] )
    {
        Scanner s = new Scanner(System.in);
        String size1 = s.nextLine();
        int size = Integer.parseInt(size1);
        if(size < 2) {
            System.out.println(0);
        } else {
            String[] str = s.nextLine().split(" ");
            int[] arr = new int[size];
            for(int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            System.out.println(maxDifference(size, arr));
        }
    }

    public static int maxDifference(int size, int[] arr) {
        int max = -1;
        int maxRight = arr[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
            }
            else {
                int diff = maxRight - arr[i];
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return max;
    }
}
