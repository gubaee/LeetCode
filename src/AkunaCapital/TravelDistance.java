package AkunaCapital;

import java.util.HashMap;
import java.util.Map;

public class TravelDistance {
    private static final int RadiusMiles = 3963;
    private static Map<String, double[]> map = new HashMap<>();
    public String Process(String line) {
        String res = "";
        if (line.charAt(0) == 'L') {
            String[] inputs = line.split(":");
            double[] temp = new double[2];
            temp[0] = Double.valueOf(inputs[2]);
            temp[1] = Double.valueOf(inputs[3]);
            map.put(inputs[1], temp);
            res = inputs[1];
        } else {
            String[] inputs = line.split(":");
            String accNum = inputs[1];
            String start = inputs[2];
            String end = inputs[3];
            res = accNum + ":" + start + ":" +end +":";

            double lat1 = map.get(start)[0] * Math.PI / 180;
            double long1 =  map.get(start)[1]* Math.PI / 180;

            double lat2 = map.get(end)[0] * Math.PI / 180;
            double long2 =  map.get(end)[1]* Math.PI / 180;

            double longdif = Math.abs(long1-long2);
            double latdif = Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)* Math.cos(longdif));
            int d = (int) Math.floor(RadiusMiles * latdif);
            res += Integer.toString(d);
        }
        return res;
    }
}

