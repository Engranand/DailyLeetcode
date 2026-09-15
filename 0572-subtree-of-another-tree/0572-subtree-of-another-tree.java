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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (same(root, subRoot)) {
            return true;
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        return left || right;
    }


    public boolean same(TreeNode root, TreeNode subroot) {

        if (root == null && subroot == null) {
            return true;
        }

        if (root == null || subroot == null) {
            return false;
        }

        if (root.val != subroot.val) {
            return false;
        }

        boolean left = same(root.left, subroot.left);
        boolean right = same(root.right, subroot.right);

        return left && right;
    }
}