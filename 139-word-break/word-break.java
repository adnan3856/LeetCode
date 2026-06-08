import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        
        // Start processing from index 0
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            // If we haven't processed this starting index yet
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordSet.contains(s.substring(start, end))) {
                        // If we can reach the end of the string, we are done
                        if (end == s.length()) {
                            return true;
                        }
                        queue.add(end);
                    }
                }
                // Mark this index as visited to prevent duplicate sub-tree evaluations
                visited[start] = true;
            }
        }

        return false;
    }
}