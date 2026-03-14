import java.util.*;

public class O2_subSequence_of_anotherChar {

    public static boolean func(String s1, String s2){
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for(int i=0; i<s1.length(); i++){
            set1.add(s1.charAt(i));
        }
        for(int i=0; i<s2.length(); i++){
            set2.add(s2.charAt(i));
        }
        int count = 0;

        for(char x : set1){
            if(set2.contains(x)){
                count++;
            }
        }
        return count == s2.length();
    }

    public static void main(String[] args) {
       
        System.out.println(func("abcde", "ace")); // true
        System.out.println(func("abcde", "aec")); // true

        // go to next qs "O3_subSequence_of_anotherChar2"
    }
}
