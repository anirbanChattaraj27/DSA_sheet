// i am a boy 
// o/p: boy
import java.util.*;

public class O2_print_hoghest_length {
    public static void main(String args[]){
        String str = "i amm a boy";
        String ans = Arrays.stream(str.split(" "))
                .max(Comparator.comparing(String::length))
                // .max((a,b) -> a.length() - b.length()) // use any one
                .get();
        
        System.out.println(ans);
    }

}
