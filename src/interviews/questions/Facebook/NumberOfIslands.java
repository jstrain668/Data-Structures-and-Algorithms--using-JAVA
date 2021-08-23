package interviews.questions.Facebook;

import java.util.LinkedList;
import java.util.Queue;

//Reference: https://medium.com/@haroon.siddiqui025/leetcode-q200-number-of-islands-medium-1957593096da
//Reference: https://stackoverflow.com/questions/50901203/dfs-and-bfs-time-and-space-complexities-of-number-of-islands-on-leetcode

public class NumberOfIslands {


    private void dfs(char[][] grid, int i, int j) {

        int numRows = grid.length;  //Row length
        int numCols = grid[0].length; //Column length

        //i represents rows, j represents columns
        //Illegal moves
        if(i < 0 || j < 0 || i >= numRows || j >= numCols || grid[i][j] != '1')
        {
            return;
        }

        grid[i][j] = '0'; //mark as visited
        //Horizontal right
        dfs(grid,i+1,j);
        //Horizontal left
        dfs(grid,i-1,j);
        //Vertical upwards
        dfs(grid,i,j-1);
        //Vertical downwards
        dfs(grid,i,j+1);

    }

    //Description: How many connected points (1s) are there in the 2d array of characters. Connected is restricted to
    //horizontal and vertical connected 1s. No diagonals, thus a possible 4 moves. A check needs to be conducted that
    // the move is OK, not going off grid and still on land. Use DFS to solve this problem.
    // Time Complexity: O(row x col)
    // Space Complexity: O(row x col) system calls - Recursive calls
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;

        int islands = 0;

        for (int i=0; i < numRows; i++) {

            for (int j=1; j < numCols; j++){

                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;

    }

    public int numIslandsBFS(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    islands++;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = { {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println("Number of islands in grid: "+noi.numIslands(grid));
    }
}
