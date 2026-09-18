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

    // 1. Main function
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        int depth = maxDepth(root);

        return findLCA(root, depth);
    }

    // 2. Find maximum depth
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    // 3. Find LCA at deepest level
    public TreeNode findLCA(TreeNode root, int depth) {

        if (root == null)
            return null;

        if (depth == 1)
            return root;

        TreeNode left = findLCA(root.left, depth - 1);
        TreeNode right = findLCA(root.right, depth - 1);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;

        return right;
    }
}
