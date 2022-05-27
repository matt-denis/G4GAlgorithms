package backtrack;

public class RatInMaze {

    static boolean thereIsPath(int[][] maze) {
        return thereIsPath(maze, 0, 0, maze.length, maze[0].length, new boolean[maze.length][maze[0].length]);
    }
    
    private static boolean thereIsPath(int[][] maze, int i, int j, final int m, final int n, boolean[][] visited) {

        if (i == m - 1 && j == n - 1) return true;
        visited[i][j] = true;
        boolean d1 = false, d2 = false, d3 = false, d4 = false;
        if (i > 0 && !visited[i - 1][j] && maze[i - 1][j] == 1) d1 = thereIsPath(maze, i - 1, j, m, n, visited);
        if (i < m - 1 && !visited[i + 1][j] && maze[i + 1][j] == 1) d2 = thereIsPath(maze, i + 1, j, m, n, visited);
        if (j > 0 && !visited[i][j - 1] && maze[i][j - 1] == 1) d3 = thereIsPath(maze, i, j - 1, m, n, visited);
        if (j < n - 1 && !visited[i][j + 1] && maze[i][j + 1] == 1) d4 = thereIsPath(maze, i, j + 1, m, n, visited);
        return d1 || d2 || d3 || d4;

    }

    public static void main(String[] args) {
        var maze = new int[4][4];
        maze[0] = new int[] {1, 0, 0, 0};
        maze[1] = new int[] {1, 1, 0, 1};
        maze[2] = new int[] {0, 1, 0, 0};
        maze[3] = new int[] {1, 1, 1, 1};
        // expected true
        System.out.println(thereIsPath(maze));
        var maze2 = new int[4][4];
        maze2[0] = new int[] {1, 0, 0, 0};
        maze2[1] = new int[] {1, 1, 0, 1};
        maze2[2] = new int[] {0, 0, 0, 0};
        maze2[3] = new int[] {1, 1, 1, 1};
        // expected false 
        System.out.println(thereIsPath(maze2));
    }

    /* Better Solution */

    static boolean solveMaze(int[][] maze) {
        final int m = maze.length;
        final int n = maze[0].length;
        return solveMaze(maze, 0, 0, m, n, new int[m][n]);
    }

    private static boolean solveMaze(final int[][] maze, int i, int j,
                                    final int m, final  int n, int[][] sol) {
                                            
        if (i == m - 1 && j == n - 1 && maze[i][j] == 1) return true;
        
        if (isSafe(maze, i, j, m, n)) {
            sol[i][j] = 1;
            if (solveMaze(maze, i + 1, j, m, n, sol)) return true;
            if (solveMaze(maze, i, j + 1, m, n, sol)) return true;
            sol[i][j] = 0;
        }
        return false; // this path does not lead to the exit of the maze
    }

    private static boolean isSafe(final int[][] maze, final int i, final int j,
                            final int m, final int n) {
        return (i < m && j < n && maze[i][j] == 1);
    }
}
