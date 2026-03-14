// The union of two arrays will contain all the elements of the two arrays, the common elements will appear only once instead of twice. The intersection of the two arrays will contain the common elements of the two arrays.


import java.util.*;

public class O1_union {
    
    public static void usingMAP(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            map.put(ch1[i], map.getOrDefault(ch1[i], 0) + 1);
        }
        for (int i = 0; i < ch1.length; i++) {
            map.put(ch2[i], map.getOrDefault(ch2[i], 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }

    public static void usingSET(String s1, String s2){
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s1.length(); i++){
            set.add(s1.charAt(i));
        }
        for(int i=0; i<s2.length(); i++){
            set.add(s2.charAt(i));
        }

        for(char x: set){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        usingSET("abbcd", "abrrc");
        System.out.println();
        usingMAP("abbcd", "abrrc");
    }
}