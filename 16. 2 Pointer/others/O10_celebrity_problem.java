// https://www.geeksforgeeks.org/dsa/the-celebrity-problem/ 
/*
Given a square matrix mat[][] of size n x n, where mat[i][j] == 1 means person i knows person j, and mat[i][j] == 0 means person i does not know person j, find the celebrity person where,

A celebrity is defined as someone who:

Is known by everyone else
Does not know anyone (except themselves)
Return the index of the celebrity if one exists, otherwise return -1.

Input: mat[][] = [[1, 1, 0], 
                  [0, 1, 0], 
                  [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity.

Input: mat[][] = [[1, 1], 
                  [1, 1]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.

Input: mat[][] = [[1]]
Output: 0

 */
public class O10_celebrity_problem {

    static int celebrity(int[][] mat) {
        int n = mat.length;

        int i = 0, j = n - 1;
        while (i < j) {

            // j knows i, thus j can't be celebrity
            if (mat[j][i] == 1) {
                j--; 
            }// else i can't be celebrity
            else {
                i++;
            }
        }

        // i points to our celebrity candidate
        int c = i;

        // check if c is actually a celebrity or not
        for (i = 0; i < n; i++) {
            if (i == c) {
                continue;
            }

            // if any person doesn't know 'c' or 'c' doesn't know any person, return -1
            if (mat[c][i] != 0 || mat[i][c] == 0) {
                return -1;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
        {0, 1, 0},
        {0, 1, 1}};
        System.out.println(celebrity(mat));
    }
}
