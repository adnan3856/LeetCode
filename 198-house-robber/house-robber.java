class Solution {
    public int rob(int[] nums) {
        int prevRob = 0, maxRob = 0;

        for(int money : nums) {
            int temp = Math.max(maxRob, prevRob + money);
            prevRob = maxRob;
            maxRob = temp;
        }
        return maxRob;
    }
}