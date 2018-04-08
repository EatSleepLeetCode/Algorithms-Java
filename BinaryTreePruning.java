
public class BinaryTreePruning 
{
    public TreeNode pruneTree(TreeNode root) 
    {
        helper(root);
        return root;
    }
    
    boolean helper(TreeNode root)
    {
        if(root == null)
            return false;
        
        boolean leftFound1 = helper(root.left);
        boolean rightFound1 = helper(root.right);
        
        if(!leftFound1)
            root.left = null;

        if(!rightFound1)
            root.right = null;
        
        if(root.val == 1 || leftFound1 || rightFound1)
            return true;
        
        return false;
    }
    
	public static void main(String[] args) 
	{
		BinaryTreePruning obj = new BinaryTreePruning();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		obj.pruneTree(root);
	}

}
