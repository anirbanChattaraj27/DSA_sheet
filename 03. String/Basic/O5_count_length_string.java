
public class O5_count_length_string{

     // Method 1
    private static int recLength(String str)
    {
        // if we reach at the end of the string
        if (str.equals(""))
            return 0;
        else
            return recLength(str.substring(1)) + 1;
    }

    // method 2
    public static int strLen(String s){
        char[] ch = s.toCharArray();
        int count = 0;
        for(int i=0; i<ch.length; i++){
            count++;
        }
        return count;
    }

    //Driver program to test the function 
    public static void main(String[] args) {
        String str ="Prepinsta";
        System.out.println("length of the string "+strLen(str));
        // strLen(str);
    }
}




// another way
// public class Main {
//     public static void main(String args[]) {
//         int i = 0;
//         String str = "Prepinsta";
//         char ch[] = str.toCharArray();
//         for (char c : ch) {
//             i++;
//         }
//         System.out.println("Length of the string = "+ i);
//     }
// }
