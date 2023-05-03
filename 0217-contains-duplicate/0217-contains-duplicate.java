class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        boolean res = true;
        for (int val : nums) {
            res = set.add(val);
            if(res == false)
                break;
        }
        return !res;
    }
}