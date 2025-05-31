class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> nodeonemap=new HashMap<>();
        HashMap<Integer, Integer> nodetwomap=new HashMap<>();
        computedistance(edges, node1, nodeonemap);
        computedistance(edges, node2, nodetwomap);
        int node=-1;
        int dist=Integer.MAX_VALUE;
        for(var entry : nodeonemap.entrySet())
        {
            int key=entry.getKey();
            int nodeonevalue=entry.getValue();
            int nodetwovalue=nodetwomap.getOrDefault(key, Integer.MAX_VALUE);
            int maxdist=Math.max(nodeonevalue, nodetwovalue);
            if(maxdist<dist || (maxdist==dist && key<node))
            {
                dist=maxdist;
                node=key;
            }
        }
        return node;
    }
    public void computedistance(int[] edges, int start, Map<Integer, Integer> map)
    {
        int distance=0;
        while(start!=-1 && !map.containsKey(start))
        {
            map.put(start, distance++);
            start=edges[start];
        }
    }
}