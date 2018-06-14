
public class MaximumPathSumRootToLeaf 
{
	public int maxPathSum(TreeNode root)
	{
	    if (root == null)
	    {
	        return 0;
	    }
	    
	    int sum = root.val;
	    int leftSum = Integer.MIN_VALUE;
	    int rightSum = Integer.MIN_VALUE;
	    
	    if (root.left == null && root.right == null)
	    {
	        return sum;
	    }
	    
	    if (root.left != null)
	    {
	        leftSum = maxPathSum(root.left);
	    }
	    
	    if (root.right != null)
	    {
	        rightSum = maxPathSum(root.right);
	    }
	    
	    return sum + Math.max(leftSum, rightSum);
	}
}
