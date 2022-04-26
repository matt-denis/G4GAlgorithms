/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1
*/

package backtrack;

import java.util.ArrayList;

class RatInMaze1 {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solveMaze(m, 0, 0, n, n, "", paths, visited);
        return paths;
    }
    
    private static void solveMaze(final int[][] maze, int i, int j,
                                    final int m, final  int n,
                                    String path, final ArrayList<String> paths,
                                    boolean[][] visited) {
                                            
        if (i == m - 1 && j == n - 1) {
            paths.add(path);
            return;
        }
        // visited[i][j] = true;
        if (isSafe(maze, i + 1, j, m, n, visited)) {
            visited[i][j] = true;
            solveMaze(maze, i + 1, j, m, n, path + "D", paths, visited);
            visited[i][j] = false;
        }
        if (isSafe(maze, i, j - 1, m, n, visited)) {
            visited[i][j] = true;
            solveMaze(maze, i, j - 1, m, n, path + "L", paths, visited);
            visited[i][j] = false;
        }
        if (isSafe(maze, i, j + 1, m, n, visited)) {
            visited[i][j] = true;
            solveMaze(maze, i, j + 1, m, n, path + "R", paths, visited);
            visited[i][j] = false;
        }
        if (isSafe(maze, i - 1, j, m, n, visited)) {
            visited[i][j] = true;
            solveMaze(maze, i - 1, j, m, n, path + "U", paths, visited);
            visited[i][j] = false;
        }
        
        
         // this path does not lead to the exit of the maze
    }

    private static boolean isSafe(final int[][] maze, final int i, final int j,
                            final int m, final int n, boolean[][] visited) {
        return (i >= 0 && j >= 0 && i < m && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}
