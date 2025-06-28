class Pair{
    int first, second;
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private void dfs(int row, int col, char[][] grid, int[][] vis)
    {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        // Only 4 directions: up, right, down, left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = 1;
                    dfs(nrow, ncol,grid, vis);
                }
            }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }

        return count;
    }
}