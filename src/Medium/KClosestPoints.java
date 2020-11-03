package Medium;
import java.util.*;
public class KClosestPoints {
    public static class DistanceAndIndex {
        double distance;
        int index;
        int [] array;
        public DistanceAndIndex(double distance, int index, int [] array) {
            this.distance = distance;
            this.index = index;
            this.array = array;
        }
    }
    public static void main(String args[]) {
        int [][] array = {{1, 3}, {-2, 2}};

        kClosest(array, 1);
    }

    public static int[][] kClosest(int[][] points, int K) {
        DistanceAndIndex [] distances = new DistanceAndIndex [points.length];
        for (int i = 0; i < points.length; i++) {
            int firstPoint = points[i][0];
            int secondPoint = points[i][1];
            double distance = Math.sqrt((firstPoint * firstPoint) + (secondPoint * secondPoint));
            distances[i] = new DistanceAndIndex(distance, i, points[i]);
        }
        Arrays.sort(distances, (o1, o2) -> {
            if (o1.distance > o2.distance) {
                return -1;
            } else if (o1.distance < o2.distance) {
                return 1;
            } else {
                return 0;
            }
        });

        int [][] result = new int[points.length][];
        for (int i = 0; i < distances.length; i++) {
            result[i] = distances[i].array;
        }
        return result;
    }
}
