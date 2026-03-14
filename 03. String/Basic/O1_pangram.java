/*
 * pangram means a word or sentence which have letters from a to z
 */

 // NOTE: isAlphabetic 🎇🎇

import java.util.*;

public class O1_pangram {

    public static boolean isPangram(String s) {
        s = s.toLowerCase();
        if (s.length() < 26) {
            return false;
        } else {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (s.indexOf(ch) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // using hashSET
    public static boolean isPangram2(String str) {
        
        str = str.toLowerCase();
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {  // 🎇🎇 this is a method to check whether a given character is an alphabetic character or not.
                set.add(c);
            }
        }
        return set.size() == 26;
    }
   
    public static void main(String[] args) {

        String sc = "the quicKK brown fox jumps over the lazy dog";
        
        System.out.println(isPangram2(sc.toLowerCase()));
    }
}
