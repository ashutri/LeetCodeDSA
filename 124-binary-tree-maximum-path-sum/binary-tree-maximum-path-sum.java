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
    
    
    public int height(TreeNode root, int[] maxSum){
        if(root == null) return 0;
        
        int lSum = Math.max(0, height(root.left, maxSum));
        int rSum = Math.max(0, height(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.val+lSum+rSum);
        
        return root.val + Math.max(lSum, rSum);
        
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        height(root, maxSum);
        return maxSum[0];
    }
}