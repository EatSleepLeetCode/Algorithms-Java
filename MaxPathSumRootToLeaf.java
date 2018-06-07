
public class MaxPathSumRootToLeaf 
{
	int maxPathSum(TreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.val;
		
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		
		if(root.left != null)
			left = maxPathSum(root.left);
		if(root.right!= null)
			right = maxPathSum(root.right);
		
		return Math.max(left, right) + root.val;
	}
	
	public static void main(String[] args)
	{
		MaxPathSumRootToLeaf obj = new MaxPathSumRootToLeaf();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right= new TreeNode(7);
		root.right.left = new TreeNode(-100);
		System.out.println(obj.maxPathSum(root));
	}
}
