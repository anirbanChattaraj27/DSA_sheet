// NOTE:  string to String array convert
//        split string to string array with spaces
//        

public class O39_print_last_char_from_string {
    public static void main(String[] args) {
        
        String str = "Java Program to print a string";
        String[] words = str.split(" ");
        
        for (String s : words) {
            char lastChar = s.charAt(s.length() - 1);
            System.out.print(lastChar);
        }
    }
}   
