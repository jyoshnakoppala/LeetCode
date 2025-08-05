class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        HashSet<Character>[] row =new HashSet[n];
        HashSet<Character>[] col =new HashSet[n];
        HashSet<Character>[] box =new HashSet[n];

        for(int i=0;i<n;i++)
        {
            row[i]=new HashSet<Character>();
            col[i]=new HashSet<Character>();
            box[i]=new HashSet<Character>();
        }

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                char cell=board[i][j];
                if(cell=='.')
                {
                    continue;
                }
                if(row[i].contains(cell)) return false;
                row[i].add(cell);

                if(col[j].contains(cell)) return false;
                col[j].add(cell);

                if(box[3*(i/3)+(j/3)].contains(cell))
                return false;

                box[3*(i/3)+(j/3)].add(cell);

            }
        }
        return true;
    }
}