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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        solve(root);

        return max;
    }

    public int solve(TreeNode root) {

        if (root == null)
            return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int leftGain = Math.max(0, left);
        int rightGain = Math.max(0, right);

        int currentPath = leftGain + root.val + rightGain;

        max = Math.max(max, currentPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}