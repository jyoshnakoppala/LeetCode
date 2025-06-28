class Solution {
    private boolean bfs(int node, int[] color, int[][] graph)
    {
        color[node]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int n=q.peek();
            q.remove();
            for(int t:graph[n])
            {
                if(color[t]==-1)
                {
                    color[t]=1-color[n];
                    q.add(t);
                }
                else if(color[t]==color[n])
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int[] color=new int[n];
        for(int i=0;i<n;i++)
        color[i]=-1;
        
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1 && !bfs(i, color, graph))
            return false;
        }
        return true;
    }
}