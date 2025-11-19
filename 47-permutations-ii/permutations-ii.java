class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> ds=new ArrayList<>();
    boolean[] used=new boolean[nums.length];
     backtrack(res, ds, nums, used);
     return res;
    }
    private void backtrack(List<List<Integer>> resultList,
                       ArrayList<Integer> tempList, int[] nums, boolean[] used) {
    // If we match the length, it is a permutation
    if (tempList.size() == nums.length
        && !resultList.contains(tempList)) {
        resultList.add(new ArrayList<>(tempList));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // Skip if we get same element
        if (used[i]) continue;

        // Add the new element and mark it as used
        used[i] = true;
        tempList.add(nums[i]);

        // Go back to try other element
        backtrack(resultList, tempList, nums, used);

        // Remove the element and mark it as unused
        used[i] = false;
        tempList.remove(tempList.size() - 1);
    }
}
}