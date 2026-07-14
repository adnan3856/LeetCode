class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);
        return result;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        
        // base
            if(target == 0){
                result.add(new ArrayList<>(current));
                return;
            }

            if(target < 0)
                return;

        for(int i=start; i<candidates.length; i++) {
            // choose
            current.add(candidates[i]);

            // explore
            backtrack(candidates, target - candidates[i], i, current, result);

            // unchoose
            current.remove(current.size() - 1);

        }
    }
}