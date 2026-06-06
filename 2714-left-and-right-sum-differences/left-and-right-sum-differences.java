class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int n = nums.length - 1;

        for(int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
            rightSum[n-i] = rightSum[n - i + 1] + nums[n - i + 1];
        }

        // System.out.println(Arrays.toString(leftSum));
        // System.out.println(Arrays.toString(rightSum));

        for(int i = 0; i< nums.length; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}