package Medium;
import java.util.*;

public class StringChallenge {
    public static void main(String args[]) {
        System.out.println(StringChallenge("mmmerme"));
        // mmmerme
        // abccdefghi
    }
    public static int StringChallenge(String str)
    {
        int n = str.length();
        int res = -1;
        int []firstInd = new int[128];

        for (int i = 0; i < 128; i++)
            firstInd[i] = -1;

        for (int i = 0; i < n; i++)
        {
            int first_ind = firstInd[str.charAt(i)];

            if (first_ind == -1)
                firstInd[str.charAt(i)] = i;
            else
                res = Math.max(res, maxUnique(str, first_ind, i));
        }
        return res;
    }

    public static int maxUnique(String str, int ind1, int ind2) {
        Set<Character> unique = new HashSet<>();
        for(int i = ind1+1; i < ind2; i++) {
            unique.add(str.charAt(i));
        }
        return unique.size();
    }
}
