// I/P: ch = geeksforgeeks
// O/P: e 
// e is the first element that repeats not g bcz e repeated for the first time


import java.util.*;

public class O5_1_first_repetating_element {

    // I/P: ch = geeksforgeeks
    // O/P: g
    // g is the first element that repeats not e bcz g appears for the first time in 0th index
    // this bellow code same as 1st non repeateting element

    public static void usingMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chArr = str.toCharArray();

        for(char ch : chArr){
            map.put(ch, map.getOrDefault(ch, 0) + 1); // default means if element is not there in map then its value is default means 0 if already value is present then its value is +1 means old count value and add +1 with it.
        }

        // for getting non-repeatetive character
        for(int i=0; i<chArr.length; i++){

            if(map.get(chArr[i]) > 1){
                System.out.println("First repeating character [using map] is->" + chArr[i]);
                break;
            }
            map.put(str.charAt(i), -1); 
        }

        // this bellow code i cant use here bcz this gives random o/p so randomly it will select repeatetive element and print that
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {

        //     if (entry.getValue() > 1) {
        //         System.out.println(entry.getKey());
        //         break;
        //     }
        // }        
    }


    static char firstRepeating(String s) {
        char[] str = s.toCharArray();
        // Creates an empty hashset
        HashSet<Character> h = new HashSet<>();

        // Traverse the input array from left to right
        for (int i = 0; i <= str.length - 1; i++) {
            char c = str[i];

            // If element is already in hash set, update x
            // and then break
            if (h.contains(c))
                return c;

            else // Else add element to hash set
                h.add(c);
        }

        return '\0';
    }


    public static void main(String[] args) {

        String str = "geeksforgeeks";
        System.out.println(firstRepeating(str));
        usingMap(str);
    }
}
