class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];

        int i = 0, j = nums.length - 1;

        while( i < nums.length) {
            if(nums[i] < pivot) {
                ans[left++] = nums[i];
            }

            if(nums[j] > pivot) {
                ans[right--] = nums[j];
            }
            i++;
            j--;
        }

        while(left <= right) {
            ans[left++] = pivot;
        }
        return ans;
    }
}