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

    boolean fun(TreeNode root1, TreeNode root2) {

        // 1. Both are NULL
        if (root1 == null && root2 == null) {
            return true;
        }

        // 2. One is NULL
        if (root1 == null || root2 == null) {
            return false;
        }

        // 3. Values are different
        if (root1.val != root2.val) {
            return false;
        }

        // 4. Mirror checking
        boolean r1 = fun(root1.left, root2.right);
        boolean r2 = fun(root1.right, root2.left);

        return r1 && r2;
    }

    public boolean isSymmetric(TreeNode root) {

        return fun(root.left, root.right);
    }
}