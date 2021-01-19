package Amazon;

import java.util.*;



public class FetchItem {
    public static void main(String args[]) {
        int numOfItems = 3;
        Map<String, PairInt> m = new HashMap<>();
        m.put("item1", new PairInt(10, 15));
        m.put("item2", new PairInt(3, 4));
        m.put("item3", new PairInt(17, 8));
        int sortParameter = 1;
        int sortOrder = 0;
        int itemsPerPage = 2;
        int pageNumber = 1;

        List<String> result = fetchItemsToDisplay(numOfItems, m, sortParameter, sortOrder, itemsPerPage, pageNumber);
        System.out.println();

    }

    static class PairInt {
        int first, second;
        PairInt() {}

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    //Fetch Item to Display
    public static List<String> fetchItemsToDisplay(int numOfItems, Map<String, PairInt> m
            , int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        List<String> res = new ArrayList<>();

        //sortParameter
        //0 - sorted by key
        //1 - sorted by relevance
        //2 - sorted by price
        Map<String, PairInt> sorted = new LinkedHashMap<>();
        Set<Map.Entry<String, PairInt>> entrySet = m.entrySet();
        List<Map.Entry<String, PairInt>> list = new ArrayList<>(entrySet);
        if(sortParameter == 0) {
            Collections.sort(list, new Comparator<Map.Entry<String, PairInt>>() {
                @Override
                public int compare(Map.Entry<String, PairInt> m1, Map.Entry<String, PairInt> m2) {
                    if(sortOrder == 0) {
                        return m1.getKey().compareTo(m2.getKey());
                    } else {
                        return m2.getKey().compareTo(m1.getKey());
                    }
                }

            });
        } else if(sortParameter == 1) {
            Collections.sort(list, new Comparator<Map.Entry<String, PairInt>>() {
                @Override
                public int compare(Map.Entry<String, PairInt> m1, Map.Entry<String, PairInt> m2) {
                    if(sortOrder == 0) {
                        return m1.getValue().first - m2.getValue().first;
                    } else {
                        return m2.getValue().first - m1.getValue().first;
                    }
                }

            });
        } else {
            Collections.sort(list, new Comparator<Map.Entry<String, PairInt>>() {
                @Override
                public int compare(Map.Entry<String, PairInt> m1, Map.Entry<String, PairInt> m2) {
                    if(sortOrder == 0) {
                        return m1.getValue().second - m2.getValue().second;
                    } else {
                        return m2.getValue().second - m1.getValue().second;
                    }
                }

            });
        }
        for(Map.Entry<String, PairInt> entry : list){
            sorted.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sorted);
        int page = 0;
        Map<Integer, List<String>> book = new HashMap<>();
        for(String key : sorted.keySet()) {
            if(book.get(page) == null) {
                book.put(page, new ArrayList<String>());
            }
            if(book.get(page).size() < itemPerPage) {
                book.get(page).add(key);
                if(book.get(page).size() == itemPerPage) {
                    page++;
                }
            }
        }

        System.out.println(book);
        return book.get(pageNumber);
    }

}
