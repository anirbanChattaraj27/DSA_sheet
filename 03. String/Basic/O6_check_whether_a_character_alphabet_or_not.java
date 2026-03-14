import java.util.*;


public class O6_check_whether_a_character_alphabet_or_not{

    // single function for both uppercase and lowercase
    static boolean isAlpha(char ch)
    {    
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            return true;
        }
        return false;
    }

    static boolean isAlpha2(char ch){
        if(Character.isAlphabetic(ch)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char c = 'c';

        // show error message if c is not an alphabet
        if (!isAlpha2 (c))
            System.out.println  (c + " Non alphabet");

        else
            System.out.println (c + " is a alphabet");
    }

}
