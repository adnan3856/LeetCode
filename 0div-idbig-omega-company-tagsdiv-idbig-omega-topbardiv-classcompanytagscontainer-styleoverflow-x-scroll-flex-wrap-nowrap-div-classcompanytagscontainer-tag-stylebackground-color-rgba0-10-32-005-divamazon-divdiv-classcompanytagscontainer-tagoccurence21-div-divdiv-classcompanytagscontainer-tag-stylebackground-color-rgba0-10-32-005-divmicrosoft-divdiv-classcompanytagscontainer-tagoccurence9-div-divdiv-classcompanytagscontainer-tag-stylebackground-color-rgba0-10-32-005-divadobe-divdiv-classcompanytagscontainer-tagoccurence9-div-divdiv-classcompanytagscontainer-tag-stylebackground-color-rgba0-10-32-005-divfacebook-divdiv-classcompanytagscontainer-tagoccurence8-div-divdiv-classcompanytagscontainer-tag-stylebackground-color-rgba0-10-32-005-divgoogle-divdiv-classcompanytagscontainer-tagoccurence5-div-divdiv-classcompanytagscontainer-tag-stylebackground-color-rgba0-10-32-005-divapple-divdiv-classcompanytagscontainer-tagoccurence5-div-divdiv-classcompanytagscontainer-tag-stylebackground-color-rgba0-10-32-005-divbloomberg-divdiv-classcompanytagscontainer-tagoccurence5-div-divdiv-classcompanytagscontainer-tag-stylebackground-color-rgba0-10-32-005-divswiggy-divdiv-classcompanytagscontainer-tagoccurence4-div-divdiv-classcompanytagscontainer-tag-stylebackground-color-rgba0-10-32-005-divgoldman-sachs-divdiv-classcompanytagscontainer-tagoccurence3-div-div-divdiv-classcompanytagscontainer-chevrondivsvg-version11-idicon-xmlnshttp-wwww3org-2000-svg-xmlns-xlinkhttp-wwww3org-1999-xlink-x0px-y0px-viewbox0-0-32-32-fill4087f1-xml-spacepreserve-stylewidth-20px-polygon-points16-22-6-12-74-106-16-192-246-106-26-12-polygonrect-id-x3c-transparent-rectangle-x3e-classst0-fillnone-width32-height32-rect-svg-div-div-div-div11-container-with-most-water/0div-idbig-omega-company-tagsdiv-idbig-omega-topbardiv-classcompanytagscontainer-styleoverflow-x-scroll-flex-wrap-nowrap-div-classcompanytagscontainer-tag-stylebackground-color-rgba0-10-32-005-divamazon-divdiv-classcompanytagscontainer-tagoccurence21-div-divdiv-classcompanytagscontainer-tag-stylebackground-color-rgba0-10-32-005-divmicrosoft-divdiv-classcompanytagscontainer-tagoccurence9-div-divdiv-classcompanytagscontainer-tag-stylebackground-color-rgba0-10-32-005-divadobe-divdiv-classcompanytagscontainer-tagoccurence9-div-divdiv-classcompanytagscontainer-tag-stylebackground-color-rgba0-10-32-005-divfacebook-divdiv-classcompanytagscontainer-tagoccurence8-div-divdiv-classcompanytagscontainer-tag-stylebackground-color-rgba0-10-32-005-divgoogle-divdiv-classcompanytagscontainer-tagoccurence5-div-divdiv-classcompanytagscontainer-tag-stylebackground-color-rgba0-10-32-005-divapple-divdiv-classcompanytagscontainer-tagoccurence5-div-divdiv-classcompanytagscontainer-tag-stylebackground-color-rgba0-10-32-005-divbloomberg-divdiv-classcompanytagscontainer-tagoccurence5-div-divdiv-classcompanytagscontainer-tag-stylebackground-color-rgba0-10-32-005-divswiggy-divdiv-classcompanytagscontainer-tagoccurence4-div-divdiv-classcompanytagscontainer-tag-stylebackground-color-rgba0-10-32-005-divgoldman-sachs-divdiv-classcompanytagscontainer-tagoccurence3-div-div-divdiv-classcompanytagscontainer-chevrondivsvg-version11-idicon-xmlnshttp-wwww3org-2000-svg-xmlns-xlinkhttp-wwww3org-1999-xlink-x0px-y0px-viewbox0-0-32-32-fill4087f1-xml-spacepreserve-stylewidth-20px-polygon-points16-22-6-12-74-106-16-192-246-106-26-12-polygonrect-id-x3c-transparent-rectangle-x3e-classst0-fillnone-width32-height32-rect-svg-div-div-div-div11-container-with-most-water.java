class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int start = 0;
        int end = height.length-1;
        while(start < end) {
           int area = Math.min(height[start], height[end]) * (end - start);
            if(area > maxWater)
                maxWater = area;
            if(Math.min(height[start], height[end]) == height[start])
                start++;
            else
                end--;
        }
        return maxWater;
    }
}