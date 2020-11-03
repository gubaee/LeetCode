package AkunaCapital;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DiskSpaceAnalysis {
    public static int segment(int x, List<Integer> space) {
        // Write your code here
        // if (x == 1) {
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < space.size(); i++) {
        //         max = Math.max(space.get(i), max);
        //     }
        //     return max;
        // }
        // int segmentBound = space.size()-x+1;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < segmentBound; i++) {
        //     int min = Integer.MAX_VALUE;
        //     for (int j = i; j < space.size() && j < i+x; j++) {
        //         min = Math.min(space.get(j), min);
        //     }
        //     max = Math.max(min, max);
        // }
        // return max;
        Deque<Integer> dq = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < x; i++) {
            dq.add(space.get(i));
            min = Math.min(space.get(i), min);
        }
        max = min;

        int segmentBound = space.size()-x+1;
        for (int i = 1; i < segmentBound; i++) {
            int left = dq.remove();
            dq.add(space.get(i+x-1));
            if (left == min) {

                min = Integer.MAX_VALUE;
                for (int j = i; j < space.size() && j < i + x; j++) {
                    min = Math.min(space.get(j), min);
                }
            }
            max = Math.max(min, max);

        }
        return max;
    }
}
