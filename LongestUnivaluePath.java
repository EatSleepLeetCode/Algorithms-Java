class LongestUnivaluePath
{
    int result = 0;
    public int longestUnivaluePath(TreeNode root) 
    {
        if (root == null) return 0;
        
        getLength(root, root.val);
        return result;
    }
    
    int getLength(TreeNode node, int val)
    {
        if (node == null) return 0;
        
        int left = getLength(node.left, node.val);
        int right = getLength(node.right, node.val);        
        result = Math.max(result, left + right);
        
        if (val == node.val)
            return Math.max(left, right) + 1;
        
        return 0;
    }
}
