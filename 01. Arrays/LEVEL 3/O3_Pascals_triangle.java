
/* LEETCODE 118
https://leetcode.com/problems/pascals-triangle/description/
https://www.geeksforgeeks.org/dsa/pascal-triangle/

*/
import java.util.*;
public class O3_Pascals_triangle {

    /*
    Time Complexity - O(n2) 
    Auxiliary Space - O(n2)
    */

    // USING DP
    static List<List<Integer>> printPascal(int n) {
        
        // An auxiliary array to store 
        // generated pascal triangle values
        List<List<Integer>> mat = new ArrayList<>();

        // Iterate through every line and 
        // print integer(s) in it
        for (int row = 0; row < n; row++) {
          
            // Every line has number of integers 
            // equal to line number
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
              
                // First and last values in every row are 1
                if (row == i || i == 0)
                    arr.add(1);
                  
                // Other values are sum of values just 
                // above and left of above
                else
                    arr.add(mat.get(row - 1).get(i - 1) + 
                            mat.get(row - 1).get(i));
            }
            mat.add(arr);
        }
        return mat;
    }

    /*
    Time Complexity - O(n2)
    Auxiliary Space - O(1)
    */
   // Using Binomial Coefficient (Space Optimized)
    static void printPascal2(int n) {
        for (int row = 1; row <= n; row++) {
          
            // nC0 = 1
            int c = 1; 
            for (int i = 1; i <= row; i++) {

                // The first value in a row is always 1
                System.out.print(c + " ");
                c = c * (row - i) / i;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> mat = printPascal(n);
        for (int i = 0; i < mat.size(); i++) {
            for(int j = 0; j < mat.get(i).size(); j++) {
                    System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
