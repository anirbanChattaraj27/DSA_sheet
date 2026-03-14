
import java.util.*;

// Class to represent a tuple with three integers
class Tuple {

    int first, second, third;

    // Constructor to initialize the tuple
    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

// Class to find the shortest path in a binary maze
class O30_shortest_dist_in_binary_maze {

    // Method to find the shortest path in a binary grid using BFS
    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        // If the source and destination are the same
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        // Queue for BFS traversal
        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Distance array initialized to a large value
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        // Initialize the starting position
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));

        // Direction vectors for moving up, down, left, right
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int dis = it.first;
            int r = it.second;
            int c = it.third;

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                // Check if new position is within bounds and is a valid path
                if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1
                        && dis + 1 < dist[newr][newc]) {

                    dist[newr][newc] = dis + 1;

                    // If destination is reached, return the distance
                    if (newr == destination[0] && newc == destination[1]) {
                        return dis + 1;
                    }

                    q.add(new Tuple(dis + 1, newr, newc));
                }
            }
        }

        // If destination is unreachable
        return -1;
    }

    // Main method to test the shortest path function
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 1, 1}
        };
        int[] source = {0, 0}; // Starting position
        int[] destination = {3, 3}; // Target position

        int result = shortestPath(grid, source, destination);
        System.out.println("Shortest Path Length: " + result);
    }
}
