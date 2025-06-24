import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        int[] leftrow=new int[n];
        int[] upper=new int[2*n-1];
        int[] lower=new int[2*n-1];

        solve(0, board, res, leftrow, upper, lower, n);
        return res;
    }
    private void solve(int col, char[][] board, List<List<String>> res, int[] left, int[] upper, int[] lower, int n)
    {
        if(col==n)
        {
            List<String> path=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                path.add(new String(board[i]));
            }
            res.add(path);
            return;
        }
        for(int row=0;row<n;row++)
        {
            if (left[row] == 0 &&
                lower[row + col] == 0 &&
                upper[n - 1 + col - row] == 0)
                {
                    board[row][col]='Q';
                    left[row] = 1;
                lower[row + col] = 1;
                upper[n - 1 + col - row] = 1;

                solve(col + 1, board, res, left, upper, lower, n);

                board[row][col] = '.';
                left[row] = 0;
                lower[row + col] = 0;
                upper[n - 1 + col - row] = 0;
                }
        }
    }
}
