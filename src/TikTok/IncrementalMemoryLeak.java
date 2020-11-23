package TikTok;
import java.util.*;

public class IncrementalMemoryLeak {
    public static void main(String args[]) {
//        String [] input = {"18 395"};
        String [] input = {"722876172662568841 154837330744832381"};
        printResult(input);
    }

    public static void printResult(String args[]) {
        for (int i = 0; i < args.length; i++) {
            String [] eachCase = args[i].split(" ");
            long m1 = Long.valueOf(eachCase[0]);
            long m2 = Long.valueOf(eachCase[1]);
            long curTime = 0;

            while (m1-curTime >= 0 || m2-curTime >= 0) {
                if (m2 > m1) {
                    m2 -= curTime;
                } else {
                    m1 -= curTime;
                }
//                System.out.println(curTime+"s: "+m1+" "+m2);
                curTime++;
            }

            System.out.println(curTime+" "+m1+" "+m2);
        }
    }
}
