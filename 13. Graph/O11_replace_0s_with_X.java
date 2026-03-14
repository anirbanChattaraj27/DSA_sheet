//this code is same as next code just here i use DFS. I can do BFS as well

// Replace O's with X's which are Surrounded Regions 

import java.util.*;

public class O11_replace_0s_with_X {

    static void dfs(int row, int col, int vis[][], char mat[][], int delrow[], int delcol[]) {
        vis[row][col] = 1; // here vis[] will mark as 1 when we call DFS
        int n = mat.length;
        int m = mat[0].length;

        // check for top, right, bottom, left 
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') { // here i am checking 4 sides if they are connected with 0 then call dfs recursively for those 0s and vis[] will marked as 1
                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }

    static char[][] fill(int n, int m, char mat[][]) {
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];

        // traverse first row and last row 
        for (int j = 0; j < m; j++) { // if i have to travarse 1st/ last row i have to travarse every col
            // check for unvisited 0's in the boundary rws
            // first row 
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol); // every time i will call DFS i will it will mark vis[] as 1
            }

            // last row 
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            // check for unvisited 0s in the boundary columns
            // first column 
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            // last column
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delrow, delcol);
            }
        }

        // if unvisited O then convert to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        char mat[][] = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        O11_replace_0s_with_X obj = new O11_replace_0s_with_X();
        char[][] ans = obj.fill(5, 4, mat);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
