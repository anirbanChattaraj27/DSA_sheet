// this code is exactly same as per bellow code just need to write 1 base case
// leetcode: 63. Unique Paths II


import java.util.Arrays;

public class O3_1_Maze_Obstacles_Memoization {

public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int [n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return f(arr, n-1, m-1, dp);
    }

    public int f(int[][] arr, int i, int j, int dp[][]){
        
        if(i < 0 || j < 0) return 0;

        if(arr[i][j] == 1) return 0;

        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int up = f(arr, i-1, j, dp);
        int left = f(arr, i, j-1, dp);

        return dp[i][j] = (up+left);

    }

    public static void main(String[] args) {
        O3_1_Maze_Obstacles_Memoization solution = new O3_1_Maze_Obstacles_Memoization();

        // 0 -> free cell
        // -1 -> obstacle
        int[][] mat = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        System.out.println("Number of Paths (with obstacles): " + solution.uniquePathsWithObstacles(mat));
    }
}
