
public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'}, //1
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'}, //3
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid3 = {
                {'0','0','0','0','0'}, //0
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid4 = null;

        System.out.println("Number of Islands in grid: "+ numIsland(grid));
        System.out.println("Number of Islands in grid: "+ numIsland(grid2));
        System.out.println("Number of Islands in grid: "+ numIsland(grid3));
        System.out.println("Number of Islands in grid: "+ numIsland(grid4));
    }

    public static int numIsland(char [][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] =='1') {
                    numIslands +=1;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j); //up
        dfs(grid, i-1, j); //down
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j -1); // down
    }
}
/*
* DFS uses own stack or via call stack with recursion LIFO
* BFS: uses queue, iterative FIFO
* */
