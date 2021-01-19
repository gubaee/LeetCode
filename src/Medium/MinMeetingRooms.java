package Medium;
import java.util.*;

public class MinMeetingRooms {
    public static void main(String args[]) {
//        int [][] array = {{13,15},{1,13}};
//        int [][] array = {{1,8},{2,20},{3,16},{13,17},{30,100},{50,99},{51,80},{52,90}};
        int [][] array = {{0, 30}, {5, 10}, {15,20}};
        System.out.println(minMeetingRooms(array));
    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int prev = pq.peek();
            int [] interval = intervals[i];

            if (prev <= interval[0]) {
                pq.remove();
            }
            pq.add(interval[1]);


        }
        return pq.size();
    }
}
