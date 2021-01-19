package Medium;
import java.util.*;

public class AstroidCollision {
    public static void main(String args[]) {
        int [] array = {5, 10, -5};
        System.out.println(asteroidCollision(array));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> pos = new Stack<Integer>();

        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            boolean add = true;

            while (!pos.isEmpty() && pos.peek() > 0 && cur < 0) {
                int posAst = pos.peek();
                if (Math.abs(cur) > Math.abs(posAst)) {
                    pos.pop();
                    continue;
                } else if (Math.abs(cur) == Math.abs(posAst)) {
                    pos.pop();
                    add = false;
                    break;
                } else {
                    add = false;
                    break;
                }
            }
            if (add) {
                pos.push(cur);
            }

        }

        int size = pos.size();
        int [] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = pos.pop();
        }

        return result;
    }
}
