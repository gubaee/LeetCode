package Peloton;

import java.util.*;
import java.util.stream.Collectors;


public class RadioStation {
    public static void main(String args[]) {
        List<String> array = new ArrayList<>();
//        array.add("Every Breath You Take");
//        array.add("Down By the River");
//        array.add("River of Dreams");
//        array.add("Take me to the River");
//        array.add("Dreams");
//        array.add("Blues Hand Me Down");
//        array.add("Forever Young");
//        array.add("American Dreams");
//        array.add("All My Love");
//        array.add("Cantaloop");
//        array.add("Take it All");
//        array.add("Love is Forever");
//        array.add("Young American");
        array.add("Bye Bye Bye");
        array.add("Bye Bye Love");
        array.add("Bye Bye Baby");
//        array.add("Expected Output");
//        array.add("Bye Bye Bye");
//        array.add("Bye Bye Baby");

        List<String> result = songChain(array);
        for (int i = 0 ; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<String> songChain(List<String> songs) {
        if (songs.size() == 0) {
            return new ArrayList<String>();
        }
        Map<String, ArrayList<String>> dic = new HashMap<>();
        String lastWord = lastWord(songs.get(0));
        for (int i = 1; i < songs.size(); i++) {
            String songName = songs.get(i);

            String [] words = songs.get(i).split(" ");
            String word = words[0];
            ArrayList<String> songNames;
            if (!dic.containsKey(word)) {
                songNames = new ArrayList<String>();
            } else {
                songNames = dic.get(word);
            }
            songNames.add(songName);
            dic.put(word, songNames);
        }

        List<String> result = new ArrayList<String>();
        result.add(songs.get(0));
        result = dfs(copyMap(dic), lastWord, new ArrayList<String>(result));
        return result;
    }
    public static List<String> dfs(Map<String, ArrayList<String>> dic, String word, List<String> result) {
        if (!dic.containsKey(word)) {
            return result;
        } else {
            ArrayList<String> listOfSongs = dic.get(word);
            Collections.sort(listOfSongs);
            // take me to the river, take it all
            List<String> resultArray = new ArrayList<>(result);
            for (int i = 0; i < listOfSongs.size(); i++) {

                String song = listOfSongs.get(i);
                String lastWord = lastWord(song);
                listOfSongs.remove(i);
                dic.put(word, listOfSongs);

                List<String> curList = new ArrayList<>(result);
                curList.add(song);
                curList = dfs(copyMap(dic), lastWord, curList);
                if (curList.size() > resultArray.size()) {
                    resultArray = new ArrayList<>(curList);
                }
                listOfSongs.add(i, song);
                dic.put(word, listOfSongs);
            }
            return resultArray;
        }
    }

    public static Map<String, ArrayList<String>> copyMap(Map<String, ArrayList<String>> source) {
        Map<String, ArrayList<String>> copy = new HashMap<String, ArrayList<String>>();
        for (Map.Entry<String, ArrayList<String>> entry : source.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<String>(entry.getValue()));
        }
        return copy;
    }
    public static String lastWord(String song) {
        String [] words = song.split(" ");
        String word = words[words.length-1];
        return word;
    }
}
