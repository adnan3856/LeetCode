class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        // base 
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i< nums.length; i++ ) {
            if(visited[i])
                continue;
            
             // =========================
            // DUPLICATE CHECK
            // =========================
            // Skip duplicate branches
            //
            // Example:
            // nums = [1,1,2]
            //
            // If first 1 is not used yet,
            // don't start another branch with second 1
            if (i > 0
                    && nums[i] == nums[i - 1]
                    && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, result);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}