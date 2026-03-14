import java.lang.Thread.State;

import javax.swing.text.html.StyleSheet;

public class O8_remove_special_char{

    public static String removeSpecialChar(String str){
        str = str.replaceAll("[^a-zA-Z0-9 ]", ""); // ^ this means other charecters except a-z, A-Z, 0-9 // here replace other charecters like special charecter with blank  // here i also add space so in output sectopn space will not remove
        return str;
    }

    public static void main(String[] args) {
        String s = "ani@$#%^&*(r)_+{b}:><A>?<|}n|*/-+ r][-`~\'/.,||ick']";
        
        System.out.println(removeSpecialChar(s));
    }
}
