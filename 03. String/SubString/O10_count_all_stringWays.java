// i/p -> abc-> 
//                 abc
//                 acb
//                 bca
//                 bac
//                 etc... total 6 ways are possible

// formula -> n X (n+1) / 2  [n = length]

public class O10_count_all_stringWays {
    static int fun(String s){
        int n = s.length();
        return n*(n+1) / 2;
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(fun(s));
    }
}
