class Solution {
     public boolean isSafe(int row, int col, List<String> board, int n) {
        int dupRow = row;
        int dupCol = col;

        // Check upper diagonal (top-left)
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        // Check left row
        col = dupCol;
        row = dupRow;
        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        // Check lower diagonal (bottom-left)
        row = dupRow;
        col = dupCol;
        while (row < n && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    public void solve(int col, List<String> board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                board.set(row, new String(rowChars));

                solve(col + 1, board, ans, n);

                rowChars[col] = '.';
                board.set(row, new String(rowChars));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);

        for (int i = 0; i < n; i++) {
            board.add(s);
        }

        solve(0, board, ans, n);
        return ans;
    }
}