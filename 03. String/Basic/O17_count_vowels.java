
public class O17_count_vowels {
    
    public static void main(String[] args) {
        
        // taking i/p
        String str = "anirban";

        str = str.toUpperCase();
        char[] ch = str.toCharArray();
        int count = 0;

        for(int i=0; i<str.length(); i++){

            // if (ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U'){
            //     count++;
            // }

            /* above and bellow code both are correct */

            if(str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'){
                count++;
            }
        }
        System.out.println(count);
    }
}