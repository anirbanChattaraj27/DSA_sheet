// NOTE-> convert chArr to String in just 1 line


// reverse vowels
// i/p = oqiatuen
// o/p = equation

// explanation --> need 2 variables start and end start starts from 0th index and end starts from last index and we are compareing charecters and reverse them

public class O21_reverse_vowel {

    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A' ||ch == 'b' || ch == 'B' || ch == 'e' || ch == 'E' || ch == 'i' ||ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
            return true;
        }
        return false;
    }

    public static String reverseVowels(String str){
        int start = 0;
        int end = str.length()-1;

        char[] charArr = str.toCharArray();

        while (start < end){
            if(!isVowel(charArr[start])){
                start++;
                continue;  // continue means no need to go next part do this itgeration again
            }

            if(!isVowel(charArr[end])){
                end--;
                continue;  // continue means no need to go next part do this itgeration again
            }

            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            start++;
            end--;
        }
        String STR = String.valueOf(charArr);
        return STR;
        // return String.valueOf(charArr);  // converts all character array into String
    }



    public static void main(String[] args) {
        
        String str = "oqiatuen";
        System.out.println(reverseVowels(str));

        // reverseVowels2(str);
    }
}
