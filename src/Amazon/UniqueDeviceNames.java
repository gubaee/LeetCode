package Amazon;
import java.util.*;

public class UniqueDeviceNames {
    public static void main(String args[]) {
        String [] array = {"switch", "tv", "switch", "tv", "switch", "tv"};
        getResult(6, array);
    }

    public static String[] getResult(int num, String [] devicenames) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String deviceName = devicenames[i];

            if (!map.containsKey(deviceName)) {
                map.put(deviceName, 0);
                continue;
            } else {
                map.put(deviceName, map.get(deviceName) + 1);
                String uniqueDeviceName = deviceName + map.get(deviceName);
                devicenames[i] = uniqueDeviceName;
            }

        }
        return devicenames;
    }
//    // below is online solution
//    public static String[] getResult(int num, String [] devicenames) {
//        Map<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < num; i++) {
//            int itemRepeatNum = map.getOrDefault(devicenames[i], 0);
//
//            if (itemRepeatNum != 0) {
//                devicenames[i] = devicenames[i] + itemRepeatNum;
//            }
//            map.put(devicenames[i], ++itemRepeatNum);
//        }
//        return devicenames;
//    }
}
