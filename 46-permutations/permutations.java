class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        // Tracks which elements are already used
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        // base
        // If permutation size becomes equal to
        // array length, one valid permutation is ready
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i< nums.length; i++) {
             // Skip if already used in current permutation
            if(visited[i])
                continue;
            // If not, Mark current element as used
            visited[i] = true;

            // choose
            // Add element to current permutation
            current.add(nums[i]);

            // explore
            backtrack(nums, visited, current, result);

            // unchoose
            // Remove last added element
            current.remove(current.size() - 1);
            // Mark element as unused
            visited[i] = false;
        }

    }
}