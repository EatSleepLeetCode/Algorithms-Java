
public class MinPathSumRootToLeaf 
{
	int maxPathSum(TreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.val;
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		
		if(root.left != null)
			left = maxPathSum(root.left);
		if(root.right!= null)
			right = maxPathSum(root.right);
		
		return Math.min(left, right) + root.val;
	}
	
	public static void main(String[] args)
	{
		MinPathSumRootToLeaf obj = new MinPathSumRootToLeaf();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right= new TreeNode(7);
		root.right.left = new TreeNode(-100);
		System.out.println(obj.maxPathSum(root));
	}
}
