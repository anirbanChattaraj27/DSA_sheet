
public class O5_count_length_string {
    //Function to calculate length

    private static int recLength(String str) {
        // if we reach at the end of the string
        if (str.equals("")) {
            return 0; 
        }else {
            return recLength(str.substring(1)) + 1;
        }
    }

    //Driver program to test the function 
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println("length of the string " + recLength(str));
        System.out.println("length of the string " + recLength2(str, 5));
    }
}
