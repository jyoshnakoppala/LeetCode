class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int label = 1;

        List<Pair<Integer, Integer>> cells = new ArrayList<>();
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) columns[i] = i;

        cells.add(new Pair<>(0, 0));
        for (int row = n - 1; row >= 0; row--) {
            for (int col : columns) {
                cells.add(new Pair<>(row, col));
            }
            Collections.reverse(Arrays.asList(columns));
        }

        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                Pair<Integer, Integer> cell = cells.get(next);
                int row = cell.getKey();
                int col = cell.getValue();
                int destination = board[row][col] != -1 ? board[row][col] : next;

                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }

        return dist[n * n];
    }
}