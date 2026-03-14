
public class O8_remove_brackets{

    public static String removeBracket(String str){
        str = str.replaceAll("[   \\[ \\] () {}   ]", " "); 
        return str;
    }

    public static void main(String[] args) {
        String s = "(a+b){a-b} = [x+y+z]";
        
        System.out.println(removeBracket(s));
    }
}

// "[ \\[ \\] (){} ]"