/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Global tracker for the number of nodes visited so far in ascending order
    private int count = 0;
    
    // Global variable to store the final answer once found
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        if(count >=k)
            return result;
        // --- STEP 1: Traverse Left Subtree ---
        // In-order traversal visits the smallest elements first by going as far left as possible.
        if (root.left != null) {
            kthSmallest(root.left, k);
        }
        
        // --- STEP 2: Process Current (Root) Node ---
        // Coming back from the left subtree means we are at the next smallest element.
        count++;
        
        // If the current node's rank matches k, we've found our kth smallest element.
        if (count == k) {
            result = root.val;
            return result; // Return early for this specific stack frame
        }
        
        // --- STEP 3: Traverse Right Subtree ---
        // If we haven't reached 'k' yet, move to the right subtree (larger elements).
        if (root.right != null) {
            kthSmallest(root.right, k);
        }
        
        // Return the accumulated result back up the call stack
        return result;
    }
}