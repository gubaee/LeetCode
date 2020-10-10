package Medium;

public class permutationInString {
    // https://leetcode.com/problems/permutation-in-string/
    public static void main(String args[]) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        int [] charCount = new int [27];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }
        if (isAllZeroes(charCount)) return true;

        for (int i = s1Length; i < s2Length; i++) {
            charCount[s2.charAt(i)-'a']--;
            charCount[s2.charAt(i-s1Length)-'a']++;
            if (isAllZeroes(charCount)) return true;
        }

        return false;
    }

    private static boolean isAllZeroes(int [] charCount) {
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
    private static void printArray(int [] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print("]");
        System.out.println();
    }


//    public static boolean checkInclusion(String s1, String s2) {
//        char[] s1Array = new char[27];
//        setUpArray(s1, s1Array);
//        int s1AsciiSum = getAsciiSum(s1);
//        boolean result = false;
//
//        for (int i = 0; i <= s2.length()-s1.length(); i++) {
//            String subString = s2.substring(i, i+s1.length());
//            int s2AsciiSum = getAsciiSum(subString);
//            if (s1AsciiSum == s2AsciiSum) {
//                // check if they are actually same
//                char[] s2Array = new char[27];
//                setUpArray(subString, s2Array);
//                result = result || checkInclusion(s1, s2Array);
//            }
//        }
//        return result;
//    }
//
//    public static int getAsciiSum(String word) {
//        int result = 0;
//        for (int i = 0; i < word.length(); i++) {
//            result += (int)word.charAt(i)-'a';
//        }
//        return result;
//    }
//
//    public static void setUpArray(String s1, char[] s1Array) {
//        for (int i = 0; i < s1.length(); i++) {
//            s1Array[s1.charAt(i)-'a']++;
//        }
//    }
//
//    private static boolean checkInclusion(String s1, char[] s2Array) {
//        for (int i = 0; i < s1.length(); i++) {
//            if (s2Array[(int)s1.charAt(i)-'a'] == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
