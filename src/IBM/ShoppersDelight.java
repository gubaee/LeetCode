package IBM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppersDelight {

//    public static void main(String args[]) {
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//        List<Integer> c = new ArrayList<>();
//        List<Integer> d = new ArrayList<>();
//        a.add(2);
//        a.add(3);
//        b.add(4);
//        c.add(2);
//        c.add(3);
//        d.add(1);
//        d.add(2);
//
//        System.out.println(getNumberOfOptions(a,b,c,d,10));
//    }

    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {
        // Write your code here
        Collections.sort(priceOfJeans);
        Collections.sort(priceOfShoes);
        Collections.sort(priceOfSkirts);
        Collections.sort(priceOfTops);

        List<Long> priceCombOfJeansAndShoes = new ArrayList<>();

        for (int i = 0; i < priceOfJeans.size(); i++) {
            for (int j = 0; j < priceOfShoes.size(); j++) {
                if ((priceOfJeans.get(i) + priceOfShoes.get(j)) >= budgeted) {
                    break;
                }
                priceCombOfJeansAndShoes.add((long) priceOfJeans.get(i) + priceOfShoes.get(j));
            }
        }

        List<Long> priceCombSkirtsAndTops = new ArrayList<>();

        for (int i = 0; i < priceOfSkirts.size(); i++) {
            for (int j = 0; j < priceOfTops.size(); j++) {
                if ((priceOfSkirts.get(i) + priceOfTops.get(j)) >= budgeted) {
                    break;
                }
                priceCombSkirtsAndTops.add((long) priceOfSkirts.get(i) + priceOfTops.get(j));
            }
        }

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < priceCombOfJeansAndShoes.size(); i++) {
            for (int j = 0; j < priceCombSkirtsAndTops.size(); j++) {
                if ((priceCombOfJeansAndShoes.get(i) + priceCombSkirtsAndTops.get(j)) > budgeted) {
                    break;
                }
                result.add((long) priceCombOfJeansAndShoes.get(i) + priceCombSkirtsAndTops.get(j));
            }
        }

        return result.size();
    }


}

