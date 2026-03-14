
/* 
    s1 = "abbcd"
    s2 = "abrrc"

    o/p -> d
*/
import java.util.*;

public class O0_unique_element_from_2_Strings {

    public static void func(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            map.put(ch1[i], map.getOrDefault(ch1[i], 0) + 1);
        }
        for (int i = 0; i < ch1.length; i++) {
            map.put(ch2[i], map.getOrDefault(ch2[i], 0) + 1);
        }

        for (Map.Entry<Character, Integer> x : map.entrySet()) {
            if (x.getValue() == 1) {
                System.out.println(x.getKey() );
            }
        }
    }

    public static void main(String[] args) {

        func("abbcd", "abrrc");
    }
}
