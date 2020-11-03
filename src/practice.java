
import java.util.*;

public class practice {
    public static List<Integer> convertArrayToList(List<Integer> list, int [] array) {
        for (int i = 0 ; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String args[]) {
        Deque <Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);

        dq.remove();
        dq.removeLast();

        dq.add(1);

        List<Integer> list = convertArrayToList(new ArrayList<Integer>(),new int [] {2,5,4,6,8});

        segment(3, list);
        int [] array = {5,3,4,2,1};
        int[] sortedArray = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
                .mapToInt(Integer::intValue)
                .toArray();
        int[] sortedArray2 = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();


    }
    public static int segment(int x, List<Integer> space) {

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
