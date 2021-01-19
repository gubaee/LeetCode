package Hard;
import java.util.*;

public class wordBreak2 {
    public static class Node{
        String sentence;
        int index;
        public Node(String sentence, int index) {
            this.sentence = sentence;
            this.index = index;
        }
    }
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        String s = "catsanddog";
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("dog");
        list.add("sand");
        wordBreak(s, list);
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Queue<Node> q = new LinkedList<>();
//        boolean [] visited = new boolean [s.length()+1];
        Set<String> dict = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        q.add(new Node("", 0));

        Map<Integer, Set<String>> visited = new HashMap<>();

        while(!q.isEmpty()) {
            Node cur = q.remove();
            String curString = cur.sentence;
            int start = cur.index;
            if (visited.get(start) == null) {
                Set<String> tempSet = new HashSet<>();
                for (int end = start + 1; end <= s.length(); end++) {
                    String subString = s.substring(start, end);
                    if (dict.contains(subString)) {
                        String toAdd = curString + " " + subString;
                        if (curString.length() == 0) {
                            toAdd = curString + subString;
                        }
                        q.add(new Node(toAdd, end));
                        tempSet.add(toAdd);
                        if (end == s.length()) {
                            result.add(toAdd);
                        }
                    }
                }
                visited.put(start, tempSet);
            } else if (visited.get(start) != null) {
                if(!visited.get(start).contains(curString)) {
                    Set<String> tempSet = visited.get(start);
                    for (int end = start + 1; end <= s.length(); end++) {
                        String subString = s.substring(start, end);
                        if (dict.contains(subString)) {
                            String toAdd = curString + " " + subString;
                            if (curString.length() == 0) {
                                toAdd = curString + subString;
                            }
                            q.add(new Node(toAdd, end));
                            tempSet.add(toAdd);
                            if (end == s.length()) {
                                result.add(toAdd);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
