// link -->  https://www.youtube.com/watch?v=iiA6Bag8UUE&list=PLlhM4lkb2sEh8AARH5oEivYOrMgaVsPFb&index=17
// https://takeuforward.org/data-structure/maximum-occurring-character-in-a-string/#:~:text=We%20can%20store%20the%20frequency,all%20the%20indexes%20with%200.

// using hash
// using priority queue
// most frequent element

import java.util.*;


public class O7_max_occuring_character {
    
    static void func1(String s){
        char ch[] = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(ch[i], map.getOrDefault(ch[i], 0) +1);
        }

        char res = 0;
        res = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println(res);
    }

    static char maxOccurringChar2(String str) {

        char ans = str.charAt(0);
        char chArr[] = str.toCharArray();
        int i, frequency = 0, max_freqency = 0, n = str.length();
        Arrays.sort(chArr);

        for (i = 1; i < n; i++) {
            if (chArr[i] == chArr[i - 1]) {
                frequency++;
            } 
            else {
                frequency = 1;
            }
            if (max_freqency < frequency) {
                max_freqency = frequency;
                ans = chArr[i - 1];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "abababavfvfbb";

        func1(str);
        System.out.println("Maximum Occurring Character is " + maxOccurringChar2(str));


    }
}
