class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(findword(i, j, 0, board, word, visited))
                return true;
            }
        }
        return false;
    }
    private boolean findword(int i, int j, int index, char[][] board, String word, boolean[][] visited)
    {
        if(index==word.length()) 
        {
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index) || visited[i][j])
        return false;

        visited[i][j]=true;
        if(
            findword(i+1, j, index+1, board, word, visited)||
            findword(i, j+1, index+1, board, word, visited)||
            findword(i-1, j, index+1, board, word, visited)||
            findword(i, j-1, index+1, board, word, visited)
        )
        return true;

        visited[i][j]=false;
        return false;
    }
}