package FacebookPractice;
import java.util.*;

public class PassingYearbooks {
    public static void main(String args[]) {
        int [] array = {2, 1};
        findSignatureCounts(array);
    }
    static int[] findSignatureCounts(int[] arr) {
        // Write your code here

        int[] bookPosition = new int[arr.length];
        int[] signedCount = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> studentSittingMap = new HashMap<>(); // key = student ID, value = where they are sitting
        Map<Integer, Integer> whoHasWhichBook = new HashMap<>(); // key = student ID value = what they are holding

        for (int i = 0; i < arr.length; i++) {
            int studentID = arr[i];
            bookPosition[i] = studentID;
            set.add(studentID);
            studentSittingMap.put(studentID, i);
            whoHasWhichBook.put(studentID, studentID);

        }

        boolean firstRound = true;
        while (!set.isEmpty()) {
            for (Map.Entry<Integer, Integer> element : whoHasWhichBook.entrySet()) {
                int currentStudent = (int) element.getKey();
                int holdingBookID = (int) element.getValue();
                if (firstRound == false && currentStudent == holdingBookID) {
                    set.remove(currentStudent);
                } else {
                    int bookIndex = studentSittingMap.get(holdingBookID);
                    signedCount[bookIndex]++;

                    int passBookToThisStudent = arr[holdingBookID - 1];
                    whoHasWhichBook.put(currentStudent, passBookToThisStudent);
                }
            }
            firstRound = false;
        }
        return signedCount;
    }
    static int getCombinationCount(int num, int num2) {
        if (num == 0) {
            return 0;
        }
        // num choose num2
        long numFactorial = 1;
        // 4!
        while (num > num-num2) {
            numFactorial *= numFactorial * num;
            num = num-1;
        }
        while (num > 0) {
            numFactorial /= numFactorial / num;
            num = num-1;
        }
        return (int) numFactorial;
    }
}
