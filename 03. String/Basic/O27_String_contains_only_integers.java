public class O27_String_contains_only_integers {

    // if i run a loop from a to z and it will encounter with any alphabet it will return false
    // if i run a loop from 0 to 9 and it will encounter with any number it will return true it will not going to check other letters at that point it will stop iteration and give the ans
    // use loop with string
    public static boolean checkIntegerString(String s){
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "prepInsta007";
        System.out.println(checkIntegerString(s));
    }

    // use loop after converting string to char[] array
    /*
    public static void main(String[] args) {
        String s ="47858gfghjcfgv5";
        // String s ="478585";
        char ch[] = s.toCharArray();
        int size = ch.length;
       
        int i = 0;
        while ( i != size) {
            if(ch[i] >= '0' && ch[i] <= '9'){
                i++;
            }
            else{
                System.out.println("not an integer string" );
                System.exit(0);
            }
        }
        System.out.println("an integer string" );
    }

*/
}
