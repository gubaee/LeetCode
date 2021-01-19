package Medium;
import java.util.*;
public class WordBreak {

    public static void main(String args[]) {
        List<String> array = new ArrayList<>();
        array.add("a");
        array.add("aa");
        array.add("aaa");
//        array.add("aaaa");
//        array.add("aaaaa");
//        array.add("aaaaaa");
//        array.add("aaaaaaa");
//        array.add("aaaaaaaa");
//        array.add("aaaaaaaaa");
//        array.add("aaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaab",array));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == false) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}
