import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree 
{
	public List<Integer> boundaryOfBinaryTree(TreeNode root)
	{
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		result.add(root.val);
		
		getElements(result, root.left, true, false);
		getElements(result, root.right, false, true);
		
		return result;
	}
	
	void getElements(List<Integer> result, TreeNode root, boolean isLeftBoundary, boolean isRightBoundary)
	{
		if(root == null)
			return;
		
		if(root.left == null && root.right == null)
		{
			result.add(root.val);
			return;
		}
		
		if(isLeftBoundary)
		{
			result.add(root.val);
		}

		getElements(result, root.left, root.left != null && isLeftBoundary, root.right == null && isRightBoundary);
		getElements(result, root.right, root.left == null && isLeftBoundary, root.right != null && isRightBoundary);

		if(isRightBoundary)
		{
			result.add(root.val);
		}
	}
	
	public static void main(String[] args)
	{
		BoundaryOfBinaryTree obj = new BoundaryOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.left.right.left= new TreeNode(7);
		root.left.right.right= new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		System.out.println(obj.boundaryOfBinaryTree(root));
	}
}
