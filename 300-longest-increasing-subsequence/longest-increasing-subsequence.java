class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            if(list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            }
            else {
                int index = binarySearch(list, num); // find the place in array
                list.set(index, num);
            }
        }
        return list.size();
        
    }

    public int binarySearch(List<Integer> res, int target) {
        int left = 0;
        int right = res.size() -1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(res.get(mid) == target)
                return mid;
            else if (res.get(mid) > target)
                right = mid - 1;
            else
                left = mid  + 1;
        }
        return left;
    }
}