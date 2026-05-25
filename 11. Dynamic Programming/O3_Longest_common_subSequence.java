//  str1 = A B C D E
//  str 2 = A 3 B D 4 4 Z
//  Longest Common Subsequence (LCS) = A B D bcz str1 and str2 contains ABD in contigous if one of them or both of them is not in contigous then they will not be LCS

import java.util.*;

public class O3_Longest_common_subSequence {

    public static int lcs(char []str1, char []str2, int m, int n) {
        if (m == 0 || n == 0) /* 🎁🎉 */
            return 0;

        if (str1[m - 1] == str2[n - 1]){  /* 🎁🎁 */
            return  1 + lcs(str1, str2, m - 1, n - 1);
        }

        return Math.max(lcs(str1, str2, m - 1, n), lcs(str1, str2, m, n - 1));  /* 🎁🎁🎉🎉 */
    }

    // this is iteretive approch and here i am creating 2D DP arary...
    public static int lcs2(char[] str1, char[] str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];  // size of array is 1idx more... if 4elements are there in row and column then size of matrix would be 4+1 && 4+1

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                // this bellow line is same as --> /* 🎁🎉 */  see above function same emoji
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }

                // this bellow line is same as --> /* 🎁🎁 */  see above function same emoji
                else if (str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // this bellow line is same as --> /* 🎁🎁🎉🎉 */ see above function same emoji
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }



    public static void main (String[]args) {
        String s1 = "AEETAB";
        String s2 = "EWTWAYB";

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        System.out.println("Length of LCS is " + lcs(str1, str2, str1.length, str2.length));

    }
}

