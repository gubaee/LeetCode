package Medium;
import java.util.*;

public class decodeString {
    public static void main(String args[]) {
//        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("10[a]10[c]"));
    }
//    public static String decodeString(String s) {
//        Stack<String> st = new Stack<>();
//        Stack <Integer> intSt = new Stack<>();
//        int i =0;
//        String result="";
//        while (i< s.length()){
//            if( Character.isDigit(s.charAt(i))){
//                int cnt =0;
//                while(Character.isDigit(s.charAt(i))){
//                    cnt = cnt*10 + Character.getNumericValue(s.charAt(i));
//                    //System.out.println(""+Character.getNumericValue(s.charAt(i)));
//                    i =i+1;
//                }
//                intSt.push(cnt);
//            }
//            else if (s.charAt(i)== ']'){
//                StringBuilder sb = new StringBuilder(st.pop());
//                int count = intSt.pop();
//                for (int j=0;j < count; j++){
//                    sb.append(result);
//                }
//                result = sb.toString();
//                i=i+1;
//            }
//            else if (s.charAt(i)== '['){
//                st.push(result);
//                result ="";
//                i=i+1;
//            }
//            else{
//                result += s.charAt(i) ;
//                i =i+1;
//            }
//            // i=i+1;
//
//        }
//        return result;
//
//    }
    public static String decodeString(String s) {
        int pointer = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(pointer < s.length()) {
            if (s.charAt(pointer) != ']') {
                stack.push(s.charAt(pointer));
            } else {
                String temp = "";
                while(stack.peek() != '[') {
                    temp += stack.pop();
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && isNum(stack.peek())) {
                    num.insert(0, stack.pop());
                }
                int count = Integer.valueOf(num.toString());
                for (int i = 0; i < count; i++) {
                    for (int j = temp.length()-1; j >= 0; j--) {
                        stack.push(temp.charAt(j));
                    }
                }

            }
            pointer++;
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();

    }
    public static boolean isNum(char ch) {
        return ch-'0' >= 0 && ch-'0' < 10;
    }
}
