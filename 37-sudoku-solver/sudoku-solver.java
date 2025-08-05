class Solution {
    public void solveSudoku(char[][] board) {
        int n=board.length;
        boolean ans=solve(board, n);
    }
    private boolean solve(char[][] board, int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char ch='1'; ch<='9';ch++)
                    {
                        if(isvalid(board, i, j, ch))
                        {
                        board[i][j]=ch;
                        if(solve(board, n)==true)
                        return true;
                        else
                        board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isvalid(char[][] board, int row, int col, char ch)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==ch)
            return false;

            if(board[i][col]==ch)
            return false;

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch)
            return false;
        }
        return true;
    }
}