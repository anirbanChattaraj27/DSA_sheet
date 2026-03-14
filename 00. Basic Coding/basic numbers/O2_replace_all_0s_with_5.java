// https://practice.geeksforgeeks.org/problems/replace-all-0s-with-5/1?page=1&category[]=Mathematical&sortBy=submissions
// NOTE: convert Int to string
//       convert Strnig to Int
public class O2_replace_all_0s_with_5 {

    static int convertfive(int num) {
        // Your code here
        String n = Integer.toString(num);
        String res = n.replace('0', '5');
        int result = Integer.parseInt(res);
        return result;
    }

    // bellow method also i can do but use reverse method to reverse final output
    static void convertfive2(int num) {
        // Your code here
        int lastDig;
        while (num > 0){
            lastDig = num%10;
            if(lastDig == 0){
                System.out.print("5");
            }
            else{
                System.out.print(lastDig);
            }
            num = num/10;
        }
    }

    public static void main(String[] args) {
        int n = 10005;
        convertfive2(n);
        System.out.println();
        System.out.println(convertfive(n));
    }
}
