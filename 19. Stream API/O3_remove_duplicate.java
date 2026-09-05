// a b b c c d
// a b c d

import java.util.*;

public class O3_remove_duplicate{
    public static void main(String args[]){
        String s = "a b b c c d";
        Arrays.stream(s.split (" "))
            .distinct()
            .forEach(System.out::print);
    }
}