class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, current, result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // base
        result.add(new ArrayList<>(current));

        for(int i=start; i< nums.length; i++) {
            //choose
            current.add(nums[i]);
            // explore
            backtrack(nums, i+1, current, result);
            //unchoose
            current.remove(current.size() - 1);
        }
    }
}