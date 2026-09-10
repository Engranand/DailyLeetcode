class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);          // ROOT

        preorder(root.left, result);   // LEFT

        preorder(root.right, result);  // RIGHT
    }
}