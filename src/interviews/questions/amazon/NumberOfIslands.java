package interviews.questions.amazon;

//Reference: https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {

    private void dfs(char[][] grid, int i, int j)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
        {
            return;
        }

        grid[i][j] = '0'; //mark as visited

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    //Description: How may connected points (1s) are there in the 2d array of characters. Connected is restricted to
    //horizontal and vertical connected 1s. No diagonals, thus a possible 4 moves. A check needs to be conducted that
    // the move is OK, not going off grid and still on land. Use DFS to solve this problem.
    // Time Complexity: O(row x col)
    // Space Complexity: O(row x col) system calls - Recursive calls
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    islands++;
                    dfs(grid,i,j);
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
