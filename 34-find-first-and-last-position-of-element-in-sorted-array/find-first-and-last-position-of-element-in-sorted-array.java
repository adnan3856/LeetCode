class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int low = 0, high = nums.length-1;

        int first = firstFind(nums, low, high, target);
        int last = lastFind(nums, low, high, target);

        return new int[]{first, last};
    }

    public int firstFind(int[] nums, int low, int high, int target) {
        int ans = -1;
        while(low <= high) {
        int mid = (low+high)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    public int lastFind(int[] nums, int low, int high, int target) {
        int ans = -1;
        while(low <= high) {
        int mid = (low+high)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}