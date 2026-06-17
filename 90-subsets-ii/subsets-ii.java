class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, current, result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for(int i=start; i< nums.length; i++) {
            
             // =========================
            // SKIP DUPLICATES
            // =========================
            // If current number is same as previous
            // and both belong to the same recursion level,
            // skip it to avoid duplicate subsets
            if(i > start && nums[i] == nums[i-1])
                continue;
            
            // choose
            current.add(nums[i]);

            // explore
            backtrack(nums, i+1, current, result);

            // unchoose
            current.remove(current.size() - 1);
        }

    }
}