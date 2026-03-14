/* find non duplicates / unique / find non repeating elements / print only distinct element */

// 2564  26544

import java.io.CharConversionException;
import java.util.*;

public class O4_2_non_repeateting_characters {

    public static void usimgMap1(String str) {
        
        Map<Character, Integer> map = new HashMap<>();
        char[] chArr = str.toCharArray();

        for (char ch : chArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); // default means if element is not there in map then its value is // default means 0 if already value is present then its value is // +1 means old count value and add +1 with it.
        }

        for(int i=0; i<str.length(); i++){
            // if(map.get(str.charAt(i)) != -1){
                if(map.get(str.charAt(i)) == 1){ // check for values
                    System.out.println(str.charAt(i)); // print characters
                    map.put(str.charAt(i), -1);
                }
            // }
        }
    }

    // dont use set bcz it will print those element which appears twice
    static void func(String s){
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
        }

        for(char x : set){
            System.out.print (x + " ");
        }
    }

    public static void main(String args[]) {

        String inputStr = "Anina";
        usimgMap1(inputStr);
        func(inputStr);
    }
}
