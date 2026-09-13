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

    public boolean isSameTree(TreeNode root1, TreeNode root2) {

        // Both are null
        if (root1 == null && root2 == null) {
            return true;
        }

        // One is null, other is not
        if (root1 == null || root2 == null) {
            return false;
        }

        // Values are different
        if (root1.val != root2.val) {
            return false;
        }

        // Compare left and right subtrees
        boolean r1 = isSameTree(root1.left, root2.left);
        boolean r2 = isSameTree(root1.right, root2.right);

        if (r1 == true && r2 == true) {
            return true;
        }

        return false;
    }
}