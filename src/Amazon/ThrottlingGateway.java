package Amazon;
import java.util.*;

public class ThrottlingGateway {
    public static void main(String args[]) {
        int [] requestTime = {1,1,1,2,2,2,3,3,3,4,4,4,4,4,4,4,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,14,14,14,15,15,15};
        Arrays.sort(requestTime);
        System.out.println(getResult(requestTime));
    }
    public static int getResult(int [] requestTime) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        Map<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < requestTime.length; i++) {
            if (!counterMap.containsKey(requestTime[i])) {
                counterMap.put(requestTime[i], 1);
            } else {
                counterMap.put(requestTime[i], counterMap.get(requestTime[i]) + 1);
            }
        }
        for (int i = 0; i < requestTime[requestTime.length-1]; i++) {
            if (!counterMap.containsKey(i)) {
                tempMap.put(i, 0);
            } else {
                tempMap.put(i, counterMap.get(i));
            }
        }

        for (int i = 3; i < requestTime.length; i++) {
            int temp = 0;
            int temp2 = 0;
            if (tempMap.containsKey(requestTime[i]-10)) {
                temp = tempMap.get(requestTime[i]-10);
            }
            if (tempMap.containsKey(requestTime[i]-60)) {
                temp2 = tempMap.get(requestTime[i]-60);
            }
            if (requestTime[i-3] == requestTime[i]) {
                requestTime[i-3] = -1;
            } else if (i+1 - temp > 20) {
                requestTime[i] = -1;
            } else if (i+1 - temp2 > 60) {
                requestTime[i] = -1;
            }
        }

        int result = 0;
        for (int i = 0; i < requestTime.length; i++) {
            if (requestTime[i] == -1) {
                result++;
            }
        }
        return result;
    }

}
