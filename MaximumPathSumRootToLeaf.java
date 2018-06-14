
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
	
	public static void main(String[] args)
	{
		MaximumPathSumRootToLeaf obj = new MaximumPathSumRootToLeaf();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(1);
		
		System.out.println(obj.maxPathSum(root));
	}
}
