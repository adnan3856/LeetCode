class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, maxNow = 0;

        for(int i = 0; i< nums.length; i++) {
            maxNow += nums[i];
            if(maxSum < maxNow)
                maxSum = maxNow;

            if(maxNow < 0)
                maxNow = 0;
        }
        return maxSum;
    }
}