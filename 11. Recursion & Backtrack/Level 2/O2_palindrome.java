
public class O2_palindrome {

    public static boolean palindromFun(String s, int n, int i){

        // once reach here that means the string is palindrome
        if(n < 0){
            return true;
        }

        // check if any of the character here is similiar if not return false
        // if dont return false definately its true so return true in above if block
        if(s.charAt(n) != s.charAt(i)){
            return false;
        }
        return palindromFun(s, n-1, i+1);
    }

    public static boolean palindromFun2(String s, int n, int i){

        int count = 0;
        if(count == n/2){
            return true;
        }

        if(s.charAt(n) == s.charAt(i)){
            count++;
        }
        else{
            return false;
        }
        
        return palindromFun(s, n-1, i+1);
    }
    
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(palindromFun(s, s.length()-1, 0));
    }
}
