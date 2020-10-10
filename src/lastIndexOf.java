import java.util.ArrayList;

public class lastIndexOf {
    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        test(arr);
        System.out.println(arr.toString());

    }

    public static int lastIndexOf(int targetNumber) {
        return -1;
    }

    public static ArrayList<Integer> test(ArrayList<Integer> arr) {
        arr.add(1);
        return arr;
    }
//    public static void main(String args[]) {
//        test();
//        ArrayList<Integer> fromMain = new ArrayList<Integer>();
//        test2(fromMain);
//        System.out.println(fromMain.toString());
//
//    }
//
//    public static int lastIndexOf(int targetNumber) {
//        return -1;
//    }
//
//    public static ArrayList<Integer> test() {
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        test2(arr);
//        System.out.println(arr.toString());
//        return arr;
//    }
//    public static int test2(ArrayList<Integer> arr) {
//        arr.add(0);
//        return 0;
//    }

}
