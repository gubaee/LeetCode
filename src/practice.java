import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class practice {
    static int totalCount = 0;
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Solider", 5);
        map.put("Recruit", 1);
        map.put("Warrior", 2);
        map.put("Captain", 1);
        map.put("Ninja", 2);
        Map<String, Integer> sortedMap = new HashMap<>();
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//        for (Map.Entry e : sortedMap.entrySet()) {
//            System.out.print((String)e.getKey() +", "+ e.getValue());
//        }

        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(x -> sortedMap.put(x.getKey(), x.getValue()));
        for (Map.Entry e : sortedMap.entrySet()) {
            System.out.print((String)e.getKey() +", "+ e.getValue());
        }



    }

    public static void cal() {

        int earnedAsMaster = 385000;
        int earnedAsPhD = -172320;
        for (int i = 5; i < 25; i++) {

            System.out.println("Master. Year: "+i+ " Amount: "+earnedAsMaster+"$");
            earnedAsMaster += 77000;

            System.out.println("PHD. Year: "+i+ "Amount: "+earnedAsPhD+"$");
            earnedAsPhD += 134000;

        }
    }
}
