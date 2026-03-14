
import java.util.*;

public class O2_print_intersection_of_strings {
    
    public static void func(String s1, String s2) {
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            set1.add(ch1[i]);
        }
        for (int i = 0; i < ch2.length; i++) {
            set2.add(ch2[i]);
        }

        for (char x : set2) {
            if(set1.contains(x)){
                System.out.println(x);
            }
            
        }
    }

    public static void main(String[] args) {

        func("abbcd", "acaffb");
        System.out.println("Hello World");
    }
}