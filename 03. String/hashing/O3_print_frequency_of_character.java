// occurence of each element

import java.util.*;

public class O3_print_frequency_of_character {

    static void characterCount(String str) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chArr = str.toCharArray();

        for (char c : chArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // without converting to char array
    public static void characterCount2(String s){

        HashMap <Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            // if(map.containsKey(s.charAt(i))){
            //     map.put(s.charAt(i), map.get(s.charAt(i))+1);
            // }
            // else{
            //     map.put(s.charAt(i), 1);
            // }

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

        }
        
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) != -1){
                
                System.out.println(s.charAt(i) + " " + map.get(s.charAt(i)));
                map.put(s.charAt(i), -1);
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "AjitjaA";
        characterCount2(str);
    }
}
