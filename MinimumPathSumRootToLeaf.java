
public class MinimumPathSumRootToLeaf 
{
	public int minPathSum(TreeNode root)
	{
	    if (root == null)
	    {
	        return 0;
	    }
	    
	    int sum = root.val;
	    int leftSum = Integer.MAX_VALUE;
	    int rightSum = Integer.MAX_VALUE;
	    
	    if (root.left == null && root.right == null)
	    {
	        return sum;
	    }
	    
	    if (root.left != null)
	    {
	        leftSum = minPathSum(root.left);
	    }
	    
	    if (root.right != null)
	    {
	        rightSum = minPathSum(root.right);
	    }
	    
	    return sum + Math.min(leftSum, rightSum);
	}
}
