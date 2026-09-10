class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        inorder(root, result); //recursive call ho rha hai yaha root input and result me store hoga 
        
        return result;
    }
    
    public void inorder(TreeNode root, List<Integer> result) {
        
        if (root == null) {
            return;
        }
        
        inorder(root.left, result); //lrft jao
        
        result.add(root.val);  //if no any child == nul add value  to list 
        
        inorder(root.right, result); //right jao 
    }
}