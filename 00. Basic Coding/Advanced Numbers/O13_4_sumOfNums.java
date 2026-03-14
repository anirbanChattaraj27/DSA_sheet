/*
 * 123 = 1+2+3  +  2+3  +  3  =  14  [i/p=123  o/p =14]
 * 123 = 1+2+3  +  1+2  +  1  =  10  [i/p=123  o/p =10]
 * 
 * to do approch 1 reverse the number 
 * to do approch 2 dont reverse the number, do directly
 */

public class O13_4_sumOfNums{

    static int reverseNumber(int n){
        String s = Integer.toString(n);
        String ss = "";
        for(int i=s.length()-1; i>=0; i--){
            ss += s.charAt(i);
        }
        return Integer.parseInt(ss);
    }

    public static void main(String[] args) {
        int n = 123;
        int rev = reverseNumber(n);
        int sum = 0;
        
        while(rev>0){
            int num = rev;
            while(num > 0){
                int last = num%10;
                sum = sum +last;
                num = num/10;
            }
            rev /=10;
        }
        System.out.println(sum);
    }
}