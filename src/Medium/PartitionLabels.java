package Medium;
import java.util.*;

public class PartitionLabels {
    public static void main(String args[]) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            int lastIndex = last[S.charAt(i)-'a'];
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
