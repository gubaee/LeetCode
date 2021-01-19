package Medium;
import java.util.*;
public class AnalyzeUserWebsiteVisitPattern {
    public static void main(String args[]) {
//        String [] username = {"dowg","dowg","dowg"};
//        int [] timestamp = {158931262,562600350,148438945};
//        String [] website = {"y","loedo","y"};
//        String [] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
//        int [] timestamp = {1,2,3,4,5,6,7,8,9,10};
//        String [] website = {"home","about","career","home","cart","maps","home","home","about","career"};

        String [] username = {"mcfwgdfkm","ir","eatfpayy","xzw","r","bqftzii","itc","vac","sdfcbf","xjkheuwrx","fvcyyg","lndqpwt","xzw","r","zjjxbqookj","hauk","lndqpwt","mcfwgdfkm","fvcyyg","mcfwgdfkm","kjkcwdhxqt","zd","r","mcfwgdfkm","uxzvbilfk","mcfwgdfkm","r","vac","zd","vac","mcfwgdfkm","vac","mcfwgdfkm"};
        int [] timestamp = {687791484,519164646,979925480,138699814,898701502,487799927,339904341,314782114,666279667,510843996,172817793,532249985,439570211,958280861,974013886,649061012,542864906,996174216,234215006,264070023,726989550,914052430,790662127,887617911,823981387,921071261,339240964,396072204,463070622,771761576,219523239,890672149,882441172};
        String [] website = {"movkvhl","movkvhl","movkvhl","pmryqb","pmryqb","movkvhl","movkvhl","movkvhl","pmryqb","movkvhl","movkvhl","movkvhl","movkvhl","ywgagmxox","movkvhl","pmryqb","movkvhl","cjalr","movkvhl","pmryqb","ywgagmxox","movkvhl","cjalr","ywgagmxox","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","ywgagmxox"};
        List<String> result = mostVisitedPattern(username, timestamp, website);
        int a = 1;
// a b a


//["mcfwgdfkm","ir","eatfpayy","xzw","r","bqftzii","itc","vac","sdfcbf","xjkheuwrx","fvcyyg","lndqpwt","xzw","r","zjjxbqookj","hauk","lndqpwt","mcfwgdfkm","fvcyyg","mcfwgdfkm","kjkcwdhxqt","zd","r","mcfwgdfkm","uxzvbilfk","mcfwgdfkm","r","vac","zd","vac","mcfwgdfkm","vac","mcfwgdfkm"]
//[687791484,519164646,979925480,138699814,898701502,487799927,339904341,314782114,666279667,510843996,172817793,532249985,439570211,958280861,974013886,649061012,542864906,996174216,234215006,264070023,726989550,914052430,790662127,887617911,823981387,921071261,339240964,396072204,463070622,771761576,219523239,890672149,882441172]
//["movkvhl","movkvhl","movkvhl","pmryqb","pmryqb","movkvhl","movkvhl","movkvhl","pmryqb","movkvhl","movkvhl","movkvhl","movkvhl","ywgagmxox","movkvhl","pmryqb","movkvhl","cjalr","movkvhl","pmryqb","ywgagmxox","movkvhl","cjalr","ywgagmxox","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","movkvhl","ywgagmxox"]
    }

    static int max = 0;
    public static class Pair {
        List<String> ori;
        int count;
        public Pair(List<String> ori, int count) {
            this.ori = ori;
            this.count = count;
        }
    }

    public static class wordWithTime {
        String word;
        int timeStamp;
        public wordWithTime(String word, int timeStamp) {
            this.word = word;
            this.timeStamp = timeStamp;
        }
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<wordWithTime>> map = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            if (!map.containsKey(username[i])) {
                List<wordWithTime> websites = new ArrayList<>();
                websites.add(new wordWithTime(website[i], timestamp[i]));
                map.put(username[i], websites);
            } else {
                List<wordWithTime> websites = map.get(username[i]);
                websites.add(new wordWithTime(website[i], timestamp[i]));
                map.put(username[i], websites);
            }
        }


        Map<String, Pair> count = new HashMap<>();

        for (Map.Entry<String, List<wordWithTime>> e : map.entrySet()) {
            List<wordWithTime> words = e.getValue();
            if (words.size() < 3) {
                continue;
            }
            Collections.sort(words, (i, j) -> i.timeStamp-j.timeStamp);

            dfs(count, 0, 3, new ArrayList(), words, new HashSet<String>());
        }


        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Pair> e: count.entrySet()) {
            if (e.getValue().count == max) {
                result.add(e.getKey());
            }
        }



        String temp = result.get(0);
        List<String> best = count.get(temp).ori;

        for (int i = 1; i < result.size(); i++) {
            String curWord = result.get(i);
            List<String> curList = count.get(curWord).ori;
            for (int j = 0; j < curList.size(); j++) {
                if (best.get(j).compareTo(curList.get(j)) < 0) {
                    break;
                }
                if (best.get(j).compareTo(curList.get(j)) > 0) {
                    best = curList;
                    break;
                }
            }
        }

        return best;
    }

    public static void dfs(Map<String, Pair> map, int i, int size, List<String> list, List<wordWithTime> words,
                           Set<String> set) {
        if (list.size() == size) {
            String key = "";

            for (int j = 0; j < list.size(); j++) {
                key += list.get(j);
            }
            if (!set.contains(key)) {
                if (!map.containsKey(key)) {
                    List<String> ori = new ArrayList<String>(list);
                    Pair pair = new Pair(ori, 1);
                    max = Math.max(1, max);
                    map.put(key, pair);

                } else {
                    Pair pair = map.get(key);
                    pair.count ++;
                    max = Math.max(pair.count, max);
                    map.put(key, pair);
                }
            }
            set.add(key);
            return;
        }

        for (int j = i; j < words.size(); j++) {
            list.add(words.get(j).word);
            dfs(map, j + 1, size, list, words, set);
            list.remove(list.size()-1);
        }
    }
}
