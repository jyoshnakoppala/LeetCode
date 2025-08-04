class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map=new HashMap<>();
        List<Integer>[] buckets=new List[nums.length+1];

        for(int i=0;i<nums.length;i++)
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        for(int key: map.keySet())
        {
            int freq=map.get(key);
            if(buckets[freq]==null)
            buckets[freq]=new ArrayList<>();
            buckets[freq].add(key);
        }

        int counter=0;
        int[] res=new int[k];
        for(int i=buckets.length-1; i>=0 && counter<k; i--)
        {
            if(buckets[i]!=null)
            {
                for(int num: buckets[i])
                {
                    res[counter++]=num;
                }
            }
        }
        return res;
    }
}