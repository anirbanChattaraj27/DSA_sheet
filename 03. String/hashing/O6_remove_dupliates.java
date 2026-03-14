// remove duplicates in array / print unique characters
// [1, 2, 3, 1, 2, 4, 5] -> [1, 2, 3, 4, 5] -> using set -> using map getKey()


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class O6_remove_dupliates {

    public static String remDup(String str){
        
        char[] ch = str.toCharArray();
        String str2 = "";
        HashSet<Character> set = new HashSet<>();

        for(char x : ch){
            if (!set.contains(x)){
                set.add(x);
                str2 += x + " ";
            }
        }
        return str2;
    }

    static void remDup2(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chArr = str.toCharArray();
        String str2 = "";

        for (char ch : chArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); // default means if element is not there in map then its value is  // default means 0 if already value is present then its value is // +1 means old count value and add +1 with it.
        }

        for(int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i)) != -1){
                // if(map.get(str.charAt(i)) == 1){
                    System.out.print(str.charAt(i) + " ");
                // }
            }
            map.put(str.charAt(i), -1);
        }

        /* this will not maintain the order */        
        // for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.print(entry.getKey() + " ");
        //     // str2 += entry.getKey(); 
        // }
        // return str2;
    }

    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        remDup2(str);
        System.out.println();
        System.out.println(remDup(str));
    }
}
