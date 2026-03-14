/* copy 5 */

public class O6_flood_fill_ALGO{

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int delRow[], int delCol[], int iniColor) {

        ans[row][col] = newColor; // color with new color
        int n = image.length;
        int m = image[0].length; 

        // there are exactly 4 neighbours
        for(int i = 0;i<4;i++) {
            int nrow = row + delRow[i]; // to get neighbourROW sum it up with delROW(i)
            int ncol = col + delCol[i]; 
            // check for valid coordinate 
            // then check for same initial color and unvisited pixel
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && // checking for validity
            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) { // if original arr's neighbour Row & neighbour Col is initaial color (i.e 1) && copyArr's neighbour R & neighbour C is NOT newColor(i.e. 2) then color it by calling recursively
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor); 
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int iniColor = image[sr][sc]; // get initial color
        int[][] ans = image; // copy original array into ansArr so ans is copied array of original array

        // delta row and delta column for neighbours
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1}; 
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor); 
        return ans;  
    }
    /* 
    i can move in 4 directions only as per qs
            R-1,C  
              | 
    R,C-1 - [R,C] - R,C+1
              |   
            R+1,C   

    delRow = -1, 0, +1, 0
    delCol =  0, +1, 0, -1

    up =    (-1, 0)
    right = (0, +1)
    down =  (+1, 0)
    left =  (0, -1)
    */

    public static void main(String[] args) {
        O6_flood_fill_ALGO obj = new O6_flood_fill_ALGO();

        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        // sr = 1, sc = 1, newColor = 2  
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}

/*
 * T.C = O(n X m)
 * S.C. = O(n X m)
 */