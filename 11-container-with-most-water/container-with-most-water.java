class Solution {
    public int maxArea(int[] nums) {
        int maxWater = 0;
        int i = 0, j = nums.length -1;
        while(i < j) {
            int currentWater = (j - i) * Math.min(nums[i], nums[j]);

            if(nums[i] <= nums[j])
                i++;
            else
                j--;

            if(currentWater > maxWater)
                maxWater = currentWater;
        }
        return maxWater;
    }
}