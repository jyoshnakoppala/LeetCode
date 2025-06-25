class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int init = image[sr][sc];
        int[][] copy=image;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        dfs(image, copy, init, sr, sc, color,delrow, delcol);
        return copy;
    }
    private void dfs(int[][] image, int[][] copy, int init, int sr, int sc, int color, int[] delrow, int[] delcol)
    {
        copy[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++)
        {
            int row=sr+delrow[i];
            int col=sc+delcol[i];
            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==init && copy[row][col]!=color)
            {
                dfs(image, copy, init, row, col, color, delrow, delcol);
            }
        }
    }
}