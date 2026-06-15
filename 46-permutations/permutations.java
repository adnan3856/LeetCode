class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result ) {
        // base
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            
            if(visited[i])
                continue;
            //choose
            visited[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(nums, visited, current, result);

            // unchoose
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}