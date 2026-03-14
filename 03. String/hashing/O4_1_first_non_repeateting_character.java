// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/



import java.util.*;
public class O4_1_first_non_repeateting_character {
    
    public static void bruteForce(String str){
        for(char i :str.toCharArray()){
            if ( str.indexOf(i) == str.lastIndexOf(i)) {
                System.out.println("BRUTE-FORCE-> "+i);
                System.out.println("BRUTE-FORCE 'INDEX' is-> "+str.indexOf(i));
                break;
            }
        }
    }

    // using map
    public static void usingMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chArr = str.toCharArray();

        for(char ch : chArr){
            map.put(ch, map.getOrDefault(ch, 0) + 1); // default means if element is not there in map then its value is default means 0 if already value is present then its value is +1 means old count value and add +1 with it.
        }

        for(int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i)) != -1){
                if(map.get(str.charAt(i)) == 1){ // check for values 
                    System.out.println("Using MAP->> " + str.charAt(i));  // print characters respect to the values
                    System.out.println("Using MAP 'INDEX'->> " + (i));
                    map.put(str.charAt(i), -1); 
                    break;
                }
            }
        }
    }
    
    public static void main(String args[]) {
     
        String inputStr ="google";

        bruteForce(inputStr);
        usingMap(inputStr);
    }
}
