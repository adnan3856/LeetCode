class Solution {
    public int longestConsecutive(int[] nums) {
        int largestStreak = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);
        
        for(int num : set) {
            if(!set.contains(num-1)) {
                int currentStreak = 1;
                while(set.contains(num + 1)) {
                    currentStreak += 1;
                    num += 1;
                }
                largestStreak = Math.max(largestStreak, currentStreak);
            }
        }
        return largestStreak;
    }
}