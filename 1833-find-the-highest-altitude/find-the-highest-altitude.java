class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int sum = 0;
        for(int i=0; i< gain.length; i++) {
            sum += gain[i];
            if(maxHeight < sum)
                maxHeight = sum;
        }
        return maxHeight;
    }
}