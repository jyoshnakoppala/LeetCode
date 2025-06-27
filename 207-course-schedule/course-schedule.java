class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++)
       {
        adj.add(new ArrayList<>());
       }
       for(int[] preq:prerequisites)
       {
        adj.get(preq[1]).add(preq[0]);
       }
       int[] visited=new int[numCourses];
       int[] path=new int[numCourses];

       for(int i=0;i<numCourses;i++)
       {
        if(visited[i]==0)
        {
        if(dfs(i, adj, path, visited))
        return false;
        }
       }
       return true;
    }
    private boolean dfs(int node, List<List<Integer>> adj, int[] path, int[] visited)
    {
        visited[node]=1;
        path[node]=1;
        for(int a:adj.get(node))
        {
            if(visited[a]==0)
            {
            if(dfs(a, adj,path, visited)==true)
            return true;
            }
            else if(path[a]==1)
            return true;
        }
        path[node]=0;
        return false;
    }
}