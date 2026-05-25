import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int m = intervals[0].length; 
        int k = 0;

        for(int i=1; i<n; i++) {
            if(intervals[k][1] >= intervals[i][0]) {
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            }
            else {
                k++;
                intervals[k] = intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals, 0, k+1);
    }
}