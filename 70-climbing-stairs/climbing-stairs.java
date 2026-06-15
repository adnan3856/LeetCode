class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];

        int prevStep = 1;
        int lastStep = 1;

        for(int i=2; i<= n; i++) {
            int currentStep = prevStep + lastStep;

            prevStep = lastStep;
            lastStep = currentStep;
        }
        return lastStep;
    }
}