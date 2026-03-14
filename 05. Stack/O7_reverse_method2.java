import java.util.Stack;

public class O7_reverse_method2{
    
    public static String reverse(String str){
        Stack<Character> st = new Stack<>();
        char[] chArr = str.toCharArray();

        for(int i = str.length()-1; i>=0; i--){
            st.push(str.charAt(i));
        }

        for(int i=0; i<str.length(); i++){
            st.pop();
        }

        return new String (chArr);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println("before reverse "  + str);
        System.out.println("after reverse "  + reverse(str));
    }
}