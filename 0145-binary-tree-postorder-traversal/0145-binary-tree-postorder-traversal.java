class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    public void postorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        postorder(root.left, result);    // LEFT

        postorder(root.right, result);   // RIGHT

        result.add(root.val);            // ROOT
    }
}