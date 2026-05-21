class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int largestStreak = 0;

        for(int num : nums) {
            set.add(num);
        }
       
        for(int num : set) {
            if(!set.contains(num-1)) {
                int currentStreak = 1;
                int currentNum = num;

                while(set.contains(currentNum + 1)) {
                    currentStreak+=1;
                    currentNum+=1;
                }
                largestStreak = Math.max(currentStreak, largestStreak);
            }
        }
       return largestStreak;
    }
}