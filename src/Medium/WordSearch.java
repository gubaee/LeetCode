package Medium;
import java.util.*;
class Index {
    int row;
    int col;
    public Index(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class WordSearch {
    static boolean result = false;
    static int count = 0;
    public static void main(String args[]) {
        char [][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        A B C E
//        S F E S
//        A D E E

//        char [][] board = {{'A'}};
        System.out.println(exist(board, "ABCESEEEFS"));
    }
    public static boolean exist(char[][] board, String word) {
        Map<Character, List<Index>> dict = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!dict.containsKey(board[i][j])) {
                    List<Index> list = new ArrayList<>();
                    list.add(new Index(i, j));
                    dict.put(board[i][j], list);
                } else {
                    List<Index> list = dict.get(board[i][j]);
                    list.add(new Index(i, j));
                    dict.put(board[i][j], list);
                }
            }
        }

        List<Index> startingPoints = dict.get(word.charAt(0));
        if (startingPoints == null) {
            return false;
        }

        for (int i = 0; i < startingPoints.size(); i++) {
            Index point = startingPoints.get(i);
            char [][] copyBoard = new char[board.length][board[0].length];
            deepCopy(board, copyBoard);
            dfs(copyBoard, word, point.row, point.col, 0);
        }
        return result;
    }

    public static void dfs(char[][] board, String word, int row, int col, int stringIndex) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(stringIndex) || board[row][col] == '0') {
            return ;
        }
        if (stringIndex == word.length()-1) {

            result = true;
            return ;
        }
        System.out.println(board[row][col]);
        count ++;

        board[row][col] = '0';
        dfs(board, word, row + 1, col, stringIndex + 1);
        dfs(board, word, row - 1, col, stringIndex + 1);
        dfs(board, word, row, col + 1, stringIndex + 1);
        dfs(board, word, row, col - 1, stringIndex + 1);
    }

    public static void deepCopy(char [][] source, char [][] dest) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                dest[i][j] = source[i][j];
            }
        }
    }
}
