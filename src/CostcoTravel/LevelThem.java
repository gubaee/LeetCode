package CostcoTravel;

import java.util.*;

public class LevelThem {
    ///////////////////// This is not completed answer key
    // Soilder, Recruitor, Ninja, Warrior, Captain
    // 1,1,1,1,1  ninja has to come first? why?
    // still need to be finalized

    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Solider", 1);
        map.put("Recruit", 1);
        map.put("Warrior", 3);
        map.put("Captain", 2);
        map.put("Ninja", 1);

        map.forEach((k,v)-> System.out.println(k + "\t" + v));
        System.out.println();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);


        Collections.sort(list, (o1, o2) ->
                (o1.getValue() == o2.getValue()) ? o1.getKey().length() - o2.getKey().length() : o2.getValue() - o1.getValue());

        String [] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i).getKey();
            int value = list.get(i).getValue();

            String eachResult = key + " - " + value;
            result[i] = eachResult;
        }

    }
//    public static String [] result(int [] points) {
//
//
//    }
//    public static String getLevel(int point) {
//        if (point < 1000) {
//            return "Recruit";
//        } else if (point < 2000) {
//            return "Soldier";
//        } else if (point < 3000) {
//            return "Warrior";
//        } else if (point < 5000) {
//            return "Captain";
//        } else {
//            return "Ninja";
//        }
//    }
}
