package Medium;
import java.util.*;

public class MergeIntervals {
    public static void main(String args[]) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int [][] array = { {1,3},{8,10},{2,6},{15,18}};
        System.out.println(merge(array));
    }
    public static int[][] merge(int[][] intervals) {
        // sort by start time
        // check i-1 end time and i start time
        // if end time is bigger than start time then combine and move to the next element
        // do that until we find things can't be merged
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int [] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        Queue<int[]> tempResult = new LinkedList<>();
        int [] prev = intervals[0];
        int resultIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            int [] cur = intervals[i];
            int prevEnd = prev[1];
            int curStart = cur[0];
            int curEnd = cur[1];
            if (curStart <= prevEnd) {
                prev[1] = curEnd;
            } else {
                tempResult.add(prev.clone()); // not sure if this cause problem cuz of reference
                prev = cur;
                resultIndex++;
            }

        }

        tempResult.add(prev.clone());

        int [][] result = new int [tempResult.size()][2];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.remove();
        }

        return result;
    }
}
