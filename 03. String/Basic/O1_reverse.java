/*
 * take a empty string named "rev" then
 * start a loop from end of the string to 0 then
 * store from last index to 1st index 1 by 1 means, suppose string = rick; so loop starts from k to r so, at first loop encounter k the store k in "rev" string then loop encounter with c so store c in "rev" and so on...
 */

class O1_reverse{

    public static String revFun(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev = rev + s.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        
        String S = "Anirban is a devoloping coder";
        System.out.println(revFun(S));
    }
}