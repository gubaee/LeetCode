package Easy;
import java.util.*;
public class LongestWordInDictionary {
    public static void main(String args[]) {
        String [] array = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        longestWord(array);
    }
    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        return findLongest(trie.root);
    }

    static String findLongest(TrieNode root) {
        String[] res = new String[]{""};
        dfs(root, res);
        return res[0];
    }

    static void dfs(TrieNode root, String[] res) {
        if (root == null || root.word == null) {
            return;
        }

        if (root.word.length() > res[0].length()) {
            res[0] = root.word;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                dfs(root.children[i], res);
            }
        }
    }


    private static class Trie {
        static TrieNode root;
        public Trie() {
            root = new TrieNode();
            root.word = "";
        }

        static void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode next = cur.children[word.charAt(i) - 'a'];
                if (next == null) {
                    next = new TrieNode();
                    cur.children[word.charAt(i) - 'a'] = next;
                }
                cur = next;
            }
            cur.word = word;
        }
    }

    private static class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
