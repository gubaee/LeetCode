import Medium.TicTacToe;

import java.util.*;
public class prac {
    public static class Pair{
        String one;
        String two;
        public Pair(String one, String two){
            this.one = one;
            this.two = two;
        }
    }
    public static void main(String args[]) {
        TicTacToe game = new TicTacToe(3);
//["TicTacToe","move","move","move","move","move","move","move","move","move"]
//[[3],[2,1,1],[1,2,2],[0,2,1],[2,2,2],[0,1,1],[0,0,2],[2,0,1],[1,0,2],[1,1,1]]
//        game.move(2,1,1);
//        game.printBoard();
//        game.move(1,2,2);
//        game.printBoard();
//        game.move(0,2,1);
//        game.printBoard();
//        game.move(2,2,2);
//        game.printBoard();
//        game.move(0,1,1);
//        game.printBoard();
//        game.move(0,0,2);
//        game.printBoard();
//        game.move(2,0,1);
//        game.printBoard();
//        game.move(1,0,2);
//        game.printBoard();
//        game.move(1,1,1);
//        game.printBoard();

    }

    public static void changeString(String [] array){
        for (int i = 0; i < array.length; i++) {
            String temp = new String(array[i]);
            temp += "change";
        }
    }
}
