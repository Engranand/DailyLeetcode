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


 /// DFS+HASHSET APPROACH 

 
// DFS + HASHSET

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();

        return solve(root, k, set);
    }

    public boolean solve(TreeNode root, int k, HashSet<Integer> set) {

        if (root == null)
            return false;

        int need = k - root.val;

        if (set.contains(need))
            return true;

        else set.add(root.val);

        if (solve(root.left, k, set))
            return true;

        if (solve(root.right, k, set))
            return true;

        return false;
    }
}