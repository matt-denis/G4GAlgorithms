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
