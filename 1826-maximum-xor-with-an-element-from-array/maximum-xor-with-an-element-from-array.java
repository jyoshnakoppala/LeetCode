class Solution {
    class Node {
        Node[] links = new Node[2];

        boolean containsKey(int bit) {
            return links[bit] != null;
        }

        Node get(int bit) {
            return links[bit];
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }
    }

    class Trie {
        private Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
            Node node = root;
            int max = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    max |= (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return max;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=queries.length;

        List<List<Integer>> que=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            List<Integer> query = new ArrayList<>();
            query.add(queries[i][1]);
            query.add(queries[i][0]);
            query.add(i);
            que.add(query);
        }

        que.sort(Comparator.comparingInt(a->a.get(0)));
        int ind=0;
        Trie trie = new Trie();
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for(int i=0;i<m;i++)
        {
            int mi = que.get(i).get(0);
            int xi = que.get(i).get(1);
            int queryInd = que.get(i).get(2);
         
            while(ind<n && nums[ind]<=mi)
            {
                trie.insert(nums[ind]);
                ind++;
            }
            if(ind!=0)
            {
                ans[queryInd]=trie.getMax(xi);
            }
        }
        return ans;
    }
}