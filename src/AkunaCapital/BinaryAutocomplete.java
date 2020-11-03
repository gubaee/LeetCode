package AkunaCapital;
import java.util.*;
public class BinaryAutocomplete {
    public static void main(String args[]) {
        List<String> result = new ArrayList<>();
        result.add("10");
        result.add("0101101010111110001001110");
        result.add("1001101101100000");
//        result.add("100110");
//        result.add("100111");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("00");
//        result.add("001");
//        result.add("0011");
//        result.add("00111");
        autocomplete(result);
        System.out.println();
    }
    private static class TrieNode{
        TrieNode[] children = new TrieNode[2];
        int prefix = -1;

        public TrieNode(int prefix){
            this.prefix = prefix;
        }
    }

    static TrieNode root = new TrieNode(-1);
    public static List<Integer> autocomplete(List<String> commands){
        ArrayList<Integer> output = new ArrayList();
        int index = 1,res = 0;
        for(String com : commands){
            TrieNode node = root;

            for(char c : com.toCharArray()){
                if(node.children[c - '0'] == null){
                    node.children[c - '0'] = new TrieNode(index);
                    node = node.children[c - '0'];
                    continue;
                }

                res = node.children[c - '0'].prefix;
                node.children[c - '0'].prefix = index;
                node = node.children[c - '0'];
            }

            output.add(res);
            res = index++;
        }

        return output;
    }
//    public static List<Integer> autocomplete(List<String> command) {
//        List<Integer> result = new ArrayList<>();
//        Map<String, Integer> map = new HashMap<>();
//        updateMap(map, command.get(0), 0);
//        result.add(0);
//
//        for (int i = 1; i < command.size(); i++) {
//            String curCommand = command.get(i);
//            int foundPrefixIndex = findPrefix(map, curCommand);
//            if (foundPrefixIndex == -1) {
//                result.add(i);
//            } else {
//                result.add(foundPrefixIndex+1);
//            }
//
//            updateMap(map, command.get(i), i);
//        }
//        return result;
//    }
//
//    public static void updateMap(Map<String, Integer> map, String s, int commandIndex) {
//        for (int i = 0; i < s.length(); i++) {
//            int subStringSize = i+1;
//            for (int j = 0; j + subStringSize <= s.length(); j++) {
//                String subString = s.substring(j, j+subStringSize);
//                map.put(subString, commandIndex);
//            }
//        }
//    }
//    public static int findPrefix(Map<String, Integer> map, String s) {
//        int sharedIndex = -1;
//        int longest = Integer.MIN_VALUE;
//        String finalString = "";
//        for (int i = 0; i < s.length(); i++) {
//            int subStringSize = i+1;
//            for (int j = 0; j + subStringSize <= s.length(); j++) {
//                String subString = s.substring(j, j+subStringSize);
//                if (map.containsKey(subString)) {
//
//                    if (subString.length() > longest) {
//                        if (s.equals("1001101101100000")) {
//                            System.out.println();
//                        }
//                        longest = subString.length();
//                        sharedIndex = map.get(subString);
//                        finalString = subString;
//                    }
//
//                }
//            }
//        }
//        return sharedIndex;
//    }
}
