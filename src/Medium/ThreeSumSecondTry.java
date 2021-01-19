package Medium;
import java.util.*;

public class ThreeSumSecondTry {
    public static void main(String args[]) {
        int [] array = {-1,0,1,2,-1,-4};
        threeSum(array);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> op = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len<3) return op;
        List l  ;
        Set<List<Integer>> s = new HashSet(); // to remove duplicate solutions
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<=len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        l  = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        Collections.sort(l); //  to bring to the same format
                        s.add(l);
                    }
                }
            }
        }
        op = new ArrayList<List<Integer>>(s);
        return op;
    }
}
