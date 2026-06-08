import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: empty string can be segmented
        dp[0] = true;

        // i represents the end of the current substring we are evaluating
        for (int i = 1; i <= s.length(); i++) {
            // j represents the split point before i
            for (int j = 0; j < i; j++) {
                // If the prefix up to j is valid, AND the remaining substring(j, i) is a word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid segmentation for length i, no need to look further
                }
            }
        }

        return dp[s.length()];
    }
}