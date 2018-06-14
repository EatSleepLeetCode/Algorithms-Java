
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
	
	public static void main(String[] args)
	{
		MinimumPathSumRootToLeaf obj = new MinimumPathSumRootToLeaf();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(1);
		
		System.out.println(obj.minPathSum(root));
	}
}
