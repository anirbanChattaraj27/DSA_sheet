// find repeating elements/ find duplicate/ remove non-repeateting elements


import java.util.*;


public class O5_2_ALL_repeateting_elements {
    
    public static void countDuplicateCharacters(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chArr = str.toCharArray();

        for (char ch : chArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); // default means if element is not there in map then its value is // default means 0 if already value is present then its value is // +1 means old count value and add +1 with it.
        }

        for(int i=0; i<str.length(); i++){
            // if(map.get(str.charAt(i)) != -1){
                if(map.get(str.charAt(i)) > 1){ // check for values
                    System.out.println(str.charAt(i)); // print characters
                    map.put(str.charAt(i), -1);
                }
            // }
        }
    }


    public static void main(String args[]) {

        String str = "geeksforgeeks";
        countDuplicateCharacters(str);
    }
}
