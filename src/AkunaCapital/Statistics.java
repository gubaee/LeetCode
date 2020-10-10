package AkunaCapital;

import java.util.*;
public class Statistics {
    private long distance = 0;
    private Map<String, Integer> visited = new HashMap<>();
    private Map<String, Integer> traveled = new HashMap<>();
    String[] mostVisited = new String[] {"","0"};
    String[] mostTraveled = new String[] {"", "0"};
    public String Process(String line) {
        String[] split = line.split(":");
        traveled.put(split[0], traveled.getOrDefault(split[0], 0) + Integer.valueOf(split[3]));
        visited.put(split[1], visited.getOrDefault(split[1], 0) + 1);
        visited.put(split[2], visited.getOrDefault(split[2], 0) + 1);
        distance += Long.valueOf(split[3]);
        for (Map.Entry<String , Integer> entry : visited.entrySet()) {
            if (entry.getValue() == Integer.parseInt(mostVisited[1])) {
                if (entry.getKey().compareTo(mostVisited[0]) < 0) {
                    mostVisited[0] = entry.getKey();
                    mostVisited[1] = entry.getValue().toString();
                }
            }
            if (entry.getValue() > Integer.parseInt(mostVisited[1])) {
                mostVisited[0] = entry.getKey();
                mostVisited[1] = entry.getValue().toString();
            }
        }

        for (Map.Entry<String, Integer> entry : traveled.entrySet()) {
            if (entry.getValue() == Integer.parseInt(mostTraveled[1])) {
                if (entry.getKey().compareTo(mostTraveled[0]) < 0) {
                    mostTraveled[0] = entry.getKey();
                    mostTraveled[1] = entry.getValue().toString();
                }
            }
            if (entry.getValue() > Integer.parseInt(mostTraveled[1])) {
                mostTraveled[0] = entry.getKey();
                mostTraveled[1] = entry.getValue().toString();
            }
        }
        return new String (distance + ":" + mostTraveled[0] + ":" + mostVisited[0]);

    }
}