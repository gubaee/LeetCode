package Easy;
import java.util.*;
public class findJudge {
    public static void main(String args[]) {
        int [][] array = {{1,3}, {2,3}};
        System.out.println(findJudge(3, array));

//        int [][] array = {{1,2}};
//        System.out.println(findJudge(2, array));
    }
    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1) {
            return 1;
        }
        if (trust.length == 0 && N-1 != trust.length) {
            return -1;
        }
        Map<Integer, Set<Integer>> judgeTrustedBy = new HashMap<>();

        Set<Integer> judges = new HashSet<>();

        for (int i = 0; i < trust.length; i++) {
            int person = trust[i][0];
            int judge = trust[i][1];

            if (!judgeTrustedBy.containsKey(judge)) {
                Set<Integer> trustedBy = new HashSet<>();
                trustedBy.add(person);
                judgeTrustedBy.put(judge, trustedBy);
            } else {
                Set<Integer> trustedBy = judgeTrustedBy.get(judge);
                trustedBy.add(person);
                judgeTrustedBy.put(judge, trustedBy);
            }

            judges.add(judge);

        }

        for (Map.Entry<Integer, Set<Integer>> e : judgeTrustedBy.entrySet()) {
            Set<Integer> trustedBy = e.getValue();
            if (trustedBy.size() == judges.size()) {

                return e.getKey();

            } else {
                if (judgeTrustedBy.containsKey(e.getKey())) {
                    return e.getKey();
                }
            }

        }
        return -1;
    }
}
