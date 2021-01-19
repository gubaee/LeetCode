import java.util.ArrayList;
import java.util.List;

public class CountCycleInGraph {
    static int V = 0;

    public static void main(String args[]) {
//        System.out.println(getResult(6, 6, new int[]{1,2,2,3,4,5}, new int []{2,4,5,5,5,6}));
        System.out.println(getResult(5, 6, new int[]{1,1,2,2,3,4}, new int []{2,3,3,4,4,5}));
//        System.out.println(getResult(7, 4, new int[]{2,3,5,1}, new int []{1,6,1,7}));
    }

    public static int getResult(int friends_nodes, int friends_edges, int [] friends_from, int [] friends_to) {
        int [][] graph = new int[friends_edges][friends_edges];
        buildAdjMatrix(graph, friends_nodes, friends_from, friends_to);
        V = friends_nodes;
        List<List<Integer>> paths = new ArrayList<>();
        int result = countCycles(graph, 3, paths);

        int asdf = 0;
        return result;
    }

    public static void buildAdjMatrix(int [][] graph, int size, int [] friends_from, int [] friends_to) {
        for (int i = 0; i < friends_from.length; i++) {
            int curNode = friends_from[i]-1;
            int friend = friends_to[i]-1;
            graph[curNode][friend] = 1;
            graph[friend][curNode] = 1;
        }
        System.out.println();

    }

    static int DFS(int graph[][], boolean marked[],
                   int n, int vert, int start, int count, List<Integer> path, List<List<Integer>> paths) {

        marked[vert] = true;
        path.add(vert);

        if (n == 0) {
            marked[vert] = false;

            if (graph[vert][start] == 1) {
                count++;
                paths.add(path);
                return count;
            } else
                return count;
        }

        for (int i = 0; i < V; i++)
            if (!marked[i] && graph[vert][i] == 1)
                count = DFS(graph, marked, n-1, i, start, count, path, paths);

        marked[vert] = false;
        return count;
    }

    static int countCycles(int graph[][], int n, List<List<Integer>> paths) {
        boolean marked[] = new boolean[V];

        int count = 0;
        for (int i = 0; i < V - (n - 1); i++) {
            count = DFS(graph, marked, n-1, i, i, count, new ArrayList<>(), paths);

            marked[i] = true;
        }

        return count / 2;
    }
}
