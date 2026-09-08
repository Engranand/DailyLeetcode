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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result);
        return result;
    }

    private void solve(TreeNode node, List<Integer> result) {
        if (node == null) return;          // base case

        solve(node.left, result);          // 1. go LEFT
        result.add(node.val);              // 2. visit ROOT
        solve(node.right, result);         // 3. go RIGHT
    }
}