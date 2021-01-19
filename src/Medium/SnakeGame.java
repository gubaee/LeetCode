package Medium;
import java.util.*;
class runGame {
    public static void main(String args[]) {
//        ["SnakeGame","move","move","move","move","move","move"]
//[[5,5,[[0,1],[0,2],[0,3]]],["R"],["R"],["R"],["D"],["L"],["U"]]


//        ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
//[[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]
        int [][] food = {{0,1},{0,2},{0,3}};
        SnakeGame game = new SnakeGame(5, 5, food);

        game.move("R");
        game.move("R");
        game.move("R");
        game.move("D");
        game.move("L");
        game.move("U");
//        game.move("D");
//        game.move("R");
//        game.move("R");
//        game.move("U");
//        game.move("L");
//        game.move("L");
//        game.move("D");
//        game.move("R");
//        game.move("U");
    }
}
class SnakeGame {
    int [][] food;
    Deque<int[]> snakePos;
    int width;
    int height;
    int score = 0;
    int [][] snakePosCount;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.snakePos = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.snakePosCount = new int[height][width];
        int [] firstPos = {0, 0};
        snakePosCount[0][0] = 1;
        snakePos.add(firstPos);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {

        int [] curPos = snakePos.peekLast();
        // [y, x]
        int curX = curPos[1];
        int curY = curPos[0];
        int nextX = curPos[1];
        int nextY = curPos[0];

        if (direction.equals("U")){
            nextY -= 1;
        } else if (direction.equals("D")) {
            nextY += 1;
        } else if (direction.equals("L")) {
            nextX -= 1;
        } else if (direction.equals("R")) {
            nextX += 1;
        }

        if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
            return -1;
        }
//        for (int i = 0; i < food.length; i++) {
//            int [] curPoss = food[i];
//            int a = 1;
//        }

        int [] foodPos = new int[2];
        if (score != food.length) {
            foodPos = food[score];
        } else {
            foodPos[0] = -1;
            foodPos[1] = -1;
        }

        
        int [] nextPos = {nextY, nextX};
        if (foodPos[0] == nextY && foodPos[1] == nextX) {
            // increase head, and everything stays same
            snakePosCount[nextY][nextX]++;
            snakePos.add(nextPos);
            score++;
            return score;
        } else {
            // move tail to head
            int [] tail = snakePos.peekFirst();
            snakePosCount[tail[0]][tail[1]]--;
            snakePosCount[nextY][nextX]++;
            if (snakePosCount[nextY][nextX] > 1) {
                return -1;
            }
            snakePos.remove();
            snakePos.add(nextPos);
            return score;
        }

    }
}