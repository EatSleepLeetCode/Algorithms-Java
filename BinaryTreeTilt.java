class BinaryTreeTilt 
{
    int result = 0;
    
    public int findTilt(TreeNode root) 
    {
        postOrder(root);
        return result;
    }
    
    int postOrder(TreeNode root)
    {
       if (root == null)
           return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        result += Math.abs(left - right);
        
        return root.val + left + right;
    }
}
