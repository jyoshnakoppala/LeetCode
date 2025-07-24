class Solution {
    class Node{
        Node[] links=new Node[2];
        boolean containsKey(int ind)
        {
           return links[ind]!=null;
        }
        Node get(int ind)
        {
            return links[ind];
        }
        void put(int ind, Node node)
        {
            links[ind]=node;
        }
    }
    class Trie{
        private static Node root;
        Trie()
        {
            root=new Node();
        }
        public void insert(int num)
        {
            Node node=root;
            for(int i=31;i>=0;i--)
            {
                int bit =(num>>i)&1;
                if(!node.containsKey(bit))
                node.put(bit, new Node());

                node=node.get(bit);
            }
        }
        public int getMax(int num)
        {
            Node node=root;
             int max=0;
            for(int i=31;i>=0;i--)
            {
                int bit=(num>>i)&1;
                if(node.containsKey(1-bit))
                {
                    max=max | (1<<i);
                    node=node.get(1-bit);
                }
                else
                {
                    node=node.get(bit);
                }
            }
            return max;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        int n=nums.length;
        for(int i=0;i<n;i++)
        trie.insert(nums[i]);

        int maxi=0;
        for(int i=0;i<n;i++)
        maxi=Math.max(maxi, trie.getMax(nums[i]));
        return maxi;
    }
}