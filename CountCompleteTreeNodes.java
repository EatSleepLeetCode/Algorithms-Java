
public class CountCompleteTreeNodes 
{
    public int countNodes(TreeNode root) 
    {
        int left = 0, right = 0;
        
        left = leftDepth(root);
        right = rightDepth(root);
        
        if (left == right)
            return (1 << left) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    int leftDepth(TreeNode root)
    {
        int depth = 0;
        
        while (root != null)
        {
            root = root.left;
            depth++;
        }
        
        return depth;
    }
    
    int rightDepth(TreeNode root)
    {
        int depth = 0;
        
        while (root != null)
        {
            root = root.right;
            depth++;
        }
        
        return depth;
    }
}
