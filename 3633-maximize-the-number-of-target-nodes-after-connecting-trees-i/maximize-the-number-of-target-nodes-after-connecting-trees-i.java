class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // Determine the actual number of nodes (not number of edges!)
        int n = edges1.length; 
        int m=edges2.length;

        List<Integer>[] tr1 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) tr1[i] = new ArrayList<>();
        for (int[] edge : edges1) {
            int u = edge[0], v = edge[1];
            tr1[u].add(v);
            tr1[v].add(u);
        }

        List<Integer>[] tr2 = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++) tr2[i] = new ArrayList<>();
        for (int[] edge : edges2) {
            int u = edge[0], v = edge[1];
            tr2[u].add(v);
            tr2[v].add(u);
        }

        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = bfscount(tr1, i, k, n + 1);
        }

        int goldencount = 0;
        for (int i = 0; i <= m; i++) {
            int count1 = bfscount(tr2, i, k - 1, m + 1);
            goldencount = Math.max(goldencount, count1);
        }

        int[] answer = new int[n + 1];
        for (int v = 0; v <= n; v++) {
            answer[v] = count[v] + goldencount;
        }

        return answer;
    }

    public int bfscount(List<Integer>[] adj, int start, int k, int size) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int dist = 0, count = 0;
        while (!queue.isEmpty() && dist <= k) {
            int s = queue.size();
            while (s-- > 0) {
                int node = queue.poll();
                count++;
                for (int ne : adj[node]) {
                    if (!visited[ne]) {
                        visited[ne] = true;
                        queue.add(ne);
                    }
                }
            }
            dist++;
        }
        return count;
    }
}