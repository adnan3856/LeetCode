class Solution {
    public int minimumOperations(int[] nums) {
         Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && !map.containsKey(nums[i]))
                map.put(nums[i],i);
        }

        return map.size();
    }
}