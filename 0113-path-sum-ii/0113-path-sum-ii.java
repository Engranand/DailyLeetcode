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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(root, targetSum, 0, path, result);

        return result;
    }

    public void solve(TreeNode root, int targetSum, int sum,
                      List<Integer> path, List<List<Integer>> result) {

        if (root == null)
            return;

        path.add(root.val);
        sum = sum + root.val;

        if (root.left == null && root.right == null) {

            if (sum == targetSum)
                result.add(new ArrayList<>(path));

            path.remove(path.size() - 1);
            return;
        }

        solve(root.left, targetSum, sum, path, result);
        solve(root.right, targetSum, sum, path, result);

        path.remove(path.size() - 1);
    }
}