// input: opentext, t
// output: open1ex2

// input: sreyasingh, s
// output: 1reya2ingh

import java.lang.annotation.Retention;

public class O9_replace_character_with_occurence {
    
    public static String checkOccuerence(String str, char x){
        str = str.toLowerCase();
        // invaild condition
        if(str.indexOf(x) == -1){
            System.out.println("chararecter is not available");
            System.exit(0);
        }

        // logic to replace occurance
        int count = 1; // here occurence of count strts from 1

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == x){ // here checking that if input characters is equal with the character that i want to replace
                str = str.replaceFirst(String.valueOf(x), String.valueOf(count)); // why replaceFIrst? bcz i want to replace first charecter with its occurence and then i increment count variable if i did replaceAll then all same charecter will replace by same value
                count++;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        
        String str = "Anirban chattaraj";
        char x = 'a';

        System.out.println(checkOccuerence(str, x));
    }
}
