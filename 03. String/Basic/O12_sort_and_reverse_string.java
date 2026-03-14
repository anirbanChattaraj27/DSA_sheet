import java.util.*;

public class O12_sort_and_reverse_string {

    public static String sorting(String str){
        String str2 = "";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        for(int i=0; i<ch.length; i++){
            str2 += ch[i];
        }
        return str2;
    }

    public static String reverse(String str){
        String rev = "";
        for(int i=str.length()-1; i>=0; i--){
            rev = rev + str.charAt(i);
        }
        return rev;
    }

    public static String sort_Reverse(String str){
        String S = sorting(str);
        String S2 = reverse(S);
        return S2;
    }
    
    public static void main(String[] args) {
        String str = "24713";
        
        System.out.println(sorting(str));
        System.out.println(reverse(str));
        System.out.println(sort_Reverse(str));
    }
}