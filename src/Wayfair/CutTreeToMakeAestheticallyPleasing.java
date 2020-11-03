package Wayfair;

public class CutTreeToMakeAestheticallyPleasing {
    public static void main(String args[]) {
//        System.out.println(solution(new int []{3, 4, 5, 3, 7}));
//        System.out.println(solution(new int []{1, 2, 3, 4}));
//        System.out.println(solution(new int []{1, 3, 1, 2}));
        System.out.println(solution(new int []{5, 5, 5}));

    }
    ///////////// this solution is not finished /////////
    public static int solution (int [] A) {
        int result = 0;

        int [] upDown = new int [A.length];
        setup(A, upDown);

        int [] duplicatesIndex = {-1, -1};
        int requiredCutDownCount = 0;
        // 4 5  7  5  6
        //   1  1 -1  1
        int zeroCount = 0;
        for (int i = 3; i < upDown.length+1; i++) {
            int upDownFirst = upDown[i-2];
            int upDownSecond = upDown[i-1];
            if (upDownFirst == upDownSecond) {
                requiredCutDownCount++;
                duplicatesIndex[0] = i-2;
                duplicatesIndex[1] = i-1;
            }
            if (requiredCutDownCount > 1) {
                return -1;
            }

        }

//        for (int i = 1; i < upDown.length; i++) {
//            if (upDown[i] == 0) {
//                zeroCount++;
//            }
//        }

//        if (A[duplicatesIndex[0]] == A[duplicatesIndex[0]+2]) {
//            return 2;
//        }

        System.out.println();
        return requiredCutDownCount == 1 ? 3 : 0;
    }
    public static void setup(int [] A, int [] upDown) {
        if (A[0] < A[1]) {
            upDown[1] = 1;
        }
        if (A[0] == A[1]) {
            upDown[1] = 1;
        }
        if (A[1] < A[0]) {
            upDown[1] = -1;
        }
        int prevHeight = A[1];
        // 1 2 3
        for (int i = 2; i < A.length; i++) {
            if (A[i] > prevHeight) {
                upDown[i] = 1;
            } else if (A[i] < prevHeight) {
                upDown[i] = -1;
            } else {
                upDown[i] = upDown[i-1];
            }
            prevHeight = A[i];
        }
    }
}

//    Example test:   [3, 4, 5, 3, 7]
//        Output:
//
//        OK
//
//        Example test:   [1, 2, 3, 4]
//        Output:
//
//        WRONG ANSWER (got 3 expected -1)
//
//        Example test:   [1, 3, 1, 2]
//        Output (stderr):
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
//        at Solution.solution(Solution.java:32)
//        at Exec.run(exec.java:48)
//        at Exec.main(exec.java:34)
//        RUNTIME ERROR (tested program terminated with exit code 1)
//
//        Producing output might cause your solution to fail performance tests.
//        You should remove code that produces output before you submit your solution.
//
//        Detected some errors.