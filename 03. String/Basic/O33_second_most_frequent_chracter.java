// https://prepinsta.com/tcs-digital/programming-questions/question-6/
// https://www.tutorialcup.com/interview/hashing/maximum-occurring-character.htm
 

// ************** READ THIS ****************
// if i will not understand this bellow code then go to hashing folder and do the code for O4_most frequent element in array then solve it with that approch
// try to solve using priority Queue as well


// NOTE-> bellow code i convert str to chArr then again convert chArr to str see the approch

import java.util.*;

public class O33_second_most_frequent_chracter {
    public static void main(String[] args) {

        String k = "i am anirban";
        char tempArray[] = k.toCharArray(); /* */

        Arrays.sort(tempArray);
        String s = new String(tempArray); /* */
        int n = s.length();

        int max_count = 0;
        int count = 1;
        char ans = '-';

        for (int i = 1; i <= n; i++) {
            if ((i == n) || (s.charAt(i) != s.charAt(i - 1))) {
                if (max_count < count) {
                    max_count = count;
                    ans = s.charAt(i - 1);
                }
                count = 1;
            } 
            else {
                count++;
            }
        }
        System.out.println("Maximum occurring character is " + ans);
    }
}
