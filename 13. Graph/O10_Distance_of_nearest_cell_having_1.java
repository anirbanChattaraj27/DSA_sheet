/* copy 9 */
import java.util.*;

class Pair {

    int first;
    int second;
    int third;

    Pair(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

public class O10_Distance_of_nearest_cell_having_1 {

    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m]; // visited and distance matrix
        int dist[][] = new int[n][m];
        
        Queue<Pair> q = new LinkedList<Pair>(); // <coordinates, steps>
        
        for (int i = 0; i < n; i++) { // traverse the matrix
            for (int j = 0; j < m; j++) {
				   
                if (grid[i][j] == 1) { // start BFS if cell contains 1
                    q.add(new Pair(i, j, 0)); // add 3 elements in Q when cell contains 1
                    vis[i][j] = 1;
                } 
				else {
                    vis[i][j] = 0; // mark unvisted 
                }
            }
        }
		// in this way i have put all initial 1s into Q AND mark them 1 in vis[] arr

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        // n x m x 4 
        // traverse till queue becomes empty
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove(); // remove 1st element from Q
            dist[row][col] = steps; // here i am adding stepCount in the dist[] arr

            // travaling for all 4 neighbours [up, down, left, right]
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i]; // neighbourROW is row itself + delRow[] arr's particular index
                int ncol = col + delcol[i];

                // check for valid unvisited cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, steps + 1));
                }
            }
        }
        // return distance matrix
        return dist;
    }

    public static void main(String[] args) {
		O10_Distance_of_nearest_cell_having_1 obj = new O10_Distance_of_nearest_cell_having_1();

        int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 0}
        };
        // int[][] grid = {
        //     {0, 1, 1, 0},
        //     {1, 1, 0, 0},
        //     {0, 0, 1, 1}
        // };

        int[][] ans = obj.nearest(grid);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * T.C: O(N * M)
 * S.C: O(N * M)
 */