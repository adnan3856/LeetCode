public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length)
            return -1;
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst()
                .orElse(-1);
    }
}