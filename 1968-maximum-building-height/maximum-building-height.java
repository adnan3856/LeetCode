import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // 1. Add the boundary conditions as restrictions
        // Building 1 always has height 0.
        // Building n has an implicit max height of n - 1 (growing by 1 each step).
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});
        for (int[] res : restrictions) {
            list.add(res);
        }
        list.add(new int[]{n, n - 1});
        
        // Sort restrictions by building ID
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int m = list.size();
        
        // 2. Left-to-Right Pass
        // A building's height cannot exceed the previous building's height + distance
        for (int i = 1; i < m; i++) {
            int id1 = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];
            int id2 = list.get(i)[0];
            int h2 = list.get(i)[1];
            
            list.get(i)[1] = Math.min(h2, h1 + (id2 - id1));
        }
        
        // 3. Right-to-Left Pass
        // A building's height cannot exceed the next building's height + distance
        for (int i = m - 2; i >= 0; i--) {
            int id1 = list.get(i)[0];
            int h1 = list.get(i)[1];
            int id2 = list.get(i + 1)[0];
            int h2 = list.get(i + 1)[1];
            
            list.get(i)[1] = Math.min(h1, h2 + (id2 - id1));
        }
        
        // 4. Find the absolute maximum height between any two adjacent restricted buildings
        int maxAns = 0;
        for (int i = 0; i < m - 1; i++) {
            int id1 = list.get(i)[0];
            int h1 = list.get(i)[1];
            int id2 = list.get(i + 1)[0];
            int h2 = list.get(i + 1)[1];
            
            // The formula to find the peak height between two points (id1, h1) and (id2, h2)
            // where slope can only be 1 or -1.
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxAns = Math.max(maxAns, peak);
        }
        
        return maxAns;
    }
}