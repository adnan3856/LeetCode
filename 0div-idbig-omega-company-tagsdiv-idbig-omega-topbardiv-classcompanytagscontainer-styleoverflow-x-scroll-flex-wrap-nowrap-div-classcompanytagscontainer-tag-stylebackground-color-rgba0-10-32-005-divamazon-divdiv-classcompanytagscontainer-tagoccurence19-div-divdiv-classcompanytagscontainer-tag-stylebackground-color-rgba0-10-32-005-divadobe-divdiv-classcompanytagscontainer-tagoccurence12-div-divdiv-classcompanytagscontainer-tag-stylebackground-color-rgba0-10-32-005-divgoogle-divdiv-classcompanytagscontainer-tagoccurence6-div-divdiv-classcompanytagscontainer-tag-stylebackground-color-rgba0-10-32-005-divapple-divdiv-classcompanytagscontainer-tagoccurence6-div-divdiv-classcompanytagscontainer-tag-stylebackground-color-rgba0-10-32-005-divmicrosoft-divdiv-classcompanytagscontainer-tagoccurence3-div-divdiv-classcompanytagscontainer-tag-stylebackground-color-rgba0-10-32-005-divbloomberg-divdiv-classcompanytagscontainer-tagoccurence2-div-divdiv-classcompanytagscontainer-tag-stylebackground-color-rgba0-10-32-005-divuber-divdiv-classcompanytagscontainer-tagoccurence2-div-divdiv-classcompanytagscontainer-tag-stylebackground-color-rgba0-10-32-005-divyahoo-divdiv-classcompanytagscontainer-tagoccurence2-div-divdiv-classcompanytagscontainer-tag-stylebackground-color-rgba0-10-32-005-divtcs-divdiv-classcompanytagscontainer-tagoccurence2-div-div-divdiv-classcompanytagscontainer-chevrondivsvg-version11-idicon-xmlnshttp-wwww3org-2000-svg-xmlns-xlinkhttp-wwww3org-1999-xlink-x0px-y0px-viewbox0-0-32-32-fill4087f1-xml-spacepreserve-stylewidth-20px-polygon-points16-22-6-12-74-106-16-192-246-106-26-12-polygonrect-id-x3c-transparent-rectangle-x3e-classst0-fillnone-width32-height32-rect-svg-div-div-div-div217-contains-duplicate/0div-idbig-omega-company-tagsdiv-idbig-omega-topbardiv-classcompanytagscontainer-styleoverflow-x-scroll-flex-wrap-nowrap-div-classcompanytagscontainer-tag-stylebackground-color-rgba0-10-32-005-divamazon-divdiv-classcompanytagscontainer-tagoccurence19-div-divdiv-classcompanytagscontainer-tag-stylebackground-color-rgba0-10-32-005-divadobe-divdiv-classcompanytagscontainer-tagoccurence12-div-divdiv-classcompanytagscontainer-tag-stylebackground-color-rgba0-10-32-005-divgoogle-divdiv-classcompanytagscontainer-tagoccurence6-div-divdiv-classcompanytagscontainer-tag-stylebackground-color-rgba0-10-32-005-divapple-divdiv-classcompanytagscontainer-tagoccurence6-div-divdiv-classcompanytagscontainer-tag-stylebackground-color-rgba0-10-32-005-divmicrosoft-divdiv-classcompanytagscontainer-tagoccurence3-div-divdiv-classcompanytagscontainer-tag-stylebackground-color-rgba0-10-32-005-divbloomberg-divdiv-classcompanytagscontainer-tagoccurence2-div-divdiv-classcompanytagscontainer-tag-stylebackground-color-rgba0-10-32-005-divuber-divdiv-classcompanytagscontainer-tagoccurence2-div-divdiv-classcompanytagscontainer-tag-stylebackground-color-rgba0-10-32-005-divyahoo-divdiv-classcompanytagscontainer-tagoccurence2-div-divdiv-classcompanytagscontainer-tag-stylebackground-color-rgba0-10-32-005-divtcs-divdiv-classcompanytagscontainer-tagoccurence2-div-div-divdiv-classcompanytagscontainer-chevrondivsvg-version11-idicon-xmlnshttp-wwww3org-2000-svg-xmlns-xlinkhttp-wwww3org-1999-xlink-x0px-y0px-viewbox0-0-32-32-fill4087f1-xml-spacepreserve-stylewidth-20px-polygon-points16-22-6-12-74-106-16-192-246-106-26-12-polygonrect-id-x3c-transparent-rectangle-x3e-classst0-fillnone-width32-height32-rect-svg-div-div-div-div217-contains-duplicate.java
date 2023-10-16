class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // boolean dup = false;
        for(int num : nums){
            if(set.add(num) == false)
                return true;
        }
        return false;
    }
}