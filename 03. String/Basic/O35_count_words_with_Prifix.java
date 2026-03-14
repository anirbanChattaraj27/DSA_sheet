// 😋😊Example 1:😋😊
// Input: words = ["pay","attention","practice","attend"], pref = "at"
// Output: 2
// Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

// 😋😊Example 2:😋😊
// Input: words = ["leetcode","win","loops","success"], pref = "code"
// Output: 0
// Explanation: There are no strings that contain "code" as a prefix.


import java.util.*;


public class O35_count_words_with_Prifix {
    public static int prefixCount(String str, String pref) {
        String words[] = str.split(" ");
        
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String enter: ");
        String str = sc.nextLine();

        System.out.println("enter prefix: ");
        String prefix = sc.next();

        System.out.println(prefixCount(str, prefix));



        String words = "pay attention practice attend";
        String pref = "at";

        System.out.println(prefixCount(words, pref));
    }
}
