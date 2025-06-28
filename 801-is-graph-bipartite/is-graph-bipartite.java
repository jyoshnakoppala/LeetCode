class Solution {
    private boolean dfs(int node, int c, int[] color, int[][] graph)
    {
        color[node]=c;
        
        for(int t:graph[node])
        {
            if(color[t]==-1)
            {
                if(dfs(t, 1-c, color, graph)==false)
                return false;
            }
            else if(color[t]==c)
            return false;
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
            if(color[i]==-1 && !dfs(i, 0, color, graph))
            return false;
        }
        return true;
    }
}