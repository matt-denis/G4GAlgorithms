package backtrack;

public class Sudoku
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
         boolean solved = fill(grid, grid.length, 0, 0);
        //  printGrid(grid);
         return solved;
    }
    
     static boolean fill(int[][] grid, int n, int row, int col) {
        // base case
        if (row == n - 1 && col == n) return true;
        if (col == n) {
            col = 0;
            row++;
        }
        // skip filled values
        if (grid[row][col] != 0) {
            return fill(grid, n, row, col + 1);
        }
        // check every possible entry from 1 to n
        for (int entry = 1; entry <= n; entry++) {
            if (isSafe(grid, row, col, entry)) {
                grid[row][col] = entry;
                if (fill(grid, n, row, col + 1)) {
                    return true;
                }
            }
        }
        grid[row][col] = 0;
        return false;
        
    }

    public static boolean isSafe(int[][] board,int row, int col, int num) 
    { 
     
        for (int d = 0; d < board.length; d++)  
        { 
            
            if (board[row][d] == num) { 
                return false; 
            } 
        } 
  
        for (int r = 0; r < board.length; r++)  
        { 
               
            if (board[r][col] == num)  
            { 
                return false; 
            } 
        }  
        int sqrt = (int)Math.sqrt(board.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 
  
        for (int r = boxRowStart; 
             r < boxRowStart + sqrt; r++)  
        { 
            for (int d = boxColStart; 
                 d < boxColStart + sqrt; d++)  
            { 
                if (board[r][d] == num)  
                { 
                    return false; 
                } 
            } 
        } 
  
        return true; 
    } 
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
