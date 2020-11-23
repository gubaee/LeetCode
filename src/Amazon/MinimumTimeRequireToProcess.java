package Amazon;
import java.util.*;

public class MinimumTimeRequireToProcess {
    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(1);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(3);
        array2.add(1);
        array2.add(4);
        array2.add(2);

        System.out.println(B14(5, array, 17));
        System.out.println(B14(4, array2, 3));
    }
    public static int B14(int num, ArrayList<Integer> ability, long processes) {
        PriorityQueue<Integer> abilities = new PriorityQueue<>((i, j) -> j - i);
        for (int processingPower : ability) {
            abilities.add(processingPower);
        }

        int processedCount = 0;
        int totalSecond = 0;

        while(processedCount < processes) {
            int processingPower = abilities.remove();
            processedCount += processingPower;
            processingPower /= 2;
            abilities.add(processingPower);
            totalSecond++;
        }

        return totalSecond;
    }
}
