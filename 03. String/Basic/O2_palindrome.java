import java.util.Scanner;

public class O2_palindrome {

    // 1 method of palindrome
    public static boolean revFun(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev = rev + s.charAt(i);
        }
        return (s.equals(rev));
        // return (s.equalsIgnoreCase(rev));
    }

    // another method of palindrome
    /*
     * take a array and change string to charecter array then  take start end then start a loop and check start[0] = end[length-1] then start[1] = end[length-2]
     */
    public static boolean isPalindrome(String str){

        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;  // 1st and last index element is not same so return false
            }
            start++;  // 1st and last index character is same then move 1st and last pointer
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
    
        String S = "bNnb";
        System.out.println( "function 1 : " + revFun(S));
        System.out.println( "function 2 : " + isPalindrome(S.toLowerCase()));

        
    }
}

