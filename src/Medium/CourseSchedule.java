package Medium;
import java.util.*;
public class CourseSchedule {

    public static void main(String args[]) {
//        int [][] array = {{1,0}, {2,0}, {3,1}, {3,2}};
        int [][] array = { };
        findOrder(2, array);
    }
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
//        int[] inDegree = new int[numCourses];
//        for(int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
//        for(int[] prerequisite: prerequisites) {
//            adj[prerequisite[1]].add(prerequisite[0]);
//            inDegree[prerequisite[0]]++;
//        }
//
//        Deque<Integer> queue = new ArrayDeque<>();
//        int[] res = new int[numCourses];
//        int visited = 0, j = 0;
//        for(int i = 0; i < numCourses; i++) if(inDegree[i] == 0) queue.add(i);
//
//        while(!queue.isEmpty()) {
//            int n = queue.poll();
//            res[j] = n;
//            j++;
//            visited++;
//
//            for(int next: adj[n]) {
//                inDegree[next]--;
//                if(inDegree[next] == 0) queue.add(next);
//            }
//        }
//
//        if(visited != numCourses) return new int[0];
//        return res;
//    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> [] adj = new ArrayList[numCourses];
        int [] indegree = new int[numCourses];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
        for (int [] cur : prerequisites) {
            adj[cur[1]].add(cur[0]);
            indegree[cur[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int [] result = new int[numCourses];
        int index = 0;
        int visited = 0;

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            result[index] = cur;
            index++;
            visited++;

            for (Integer next : adj[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return visited == numCourses ? result : new int[0];
    }
}
