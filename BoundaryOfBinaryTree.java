import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryOfBinaryTree 
{
	//This recursive solution works for all cases
	public List<Integer> boundaryOfBinaryTree(TreeNode root)
	{
		List<Integer> result = new ArrayList<Integer>();
		result.add(root.val);
		getLeftBoundary(root.left, result);
		getLeafBoundary(root.left, result);
		getLeafBoundary(root.right, result);
		getRightBoundary(root.right, result);
		return result;
	}
	
	void getLeftBoundary(TreeNode node, List<Integer> curr)
	{
		if(node == null)
			return;
		
		if(node.left != null)
		{
			curr.add(node.val);
			getLeftBoundary(node.left, curr);
		}
		else if(node.right!= null)
		{
			curr.add(node.val);
			getLeftBoundary(node.right, curr);
		}
	}

	void getRightBoundary(TreeNode node, List<Integer> curr)
	{
		if(node == null)
			return;
		
		if(node.right != null)
		{
			getRightBoundary(node.right, curr);
			curr.add(node.val);
		}
		else if(node.left!= null)
		{
			getRightBoundary(node.left, curr);
			curr.add(node.val);
		}
	}
	
	void getLeafBoundary(TreeNode node, List<Integer> curr)
	{
		if(node == null)
			return;
		
		getLeafBoundary(node.left, curr);
		
		if(node.left == null && node.right == null)
		{
			curr.add(node.val);
		}
		
		getLeafBoundary(node.right, curr);
	}

	/*
	//This iterative solution only works for complete or full binary tree
	public List<Integer> boundaryOfBinaryTree(TreeNode root)
	{
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> leaf = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Boolean> isLeftNodeQ = new LinkedList<Boolean>();
		
		q.offer(root);
		isLeftNodeQ.offer(true);
		
		while(!q.isEmpty())
		{
			int size = q.size();		
			for(int i = 0; i < size; i++)
			{
				boolean isLeaf = true;
				
				TreeNode curr = q.poll();
				boolean isLeft= isLeftNodeQ.poll();
				
				if(curr.left != null)
				{
					q.offer(curr.left);
					isLeftNodeQ.offer(true);
					isLeaf = false;
				}			
				if(curr.right != null)
				{
					q.offer(curr.right);
					isLeftNodeQ.offer(false);
					isLeaf = false;
				}
	
				if(isLeaf)
				{
					leaf.add(curr.val);
				}
				else if(size == 1)
				{
					if(isLeft)
						left.add(curr.val);
					else
						right.add(0, curr.val);
				}
				else if(size > 1)
				{
					if(i == 0)
					{
						left.add(curr.val);
					}
					else if(i == size - 1)
					{
						right.add(0, curr.val);
					}
				}
			}
		}
		
		for(int leftNode : left)
		{
			result.add(leftNode);
		}
		for(int leafNode : leaf)
		{
			result.add(leafNode);
		}
		for(int rightNode : right)
		{
			result.add(rightNode);
		}	
		
		return result;
	}
	*/
	
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
		
//		BoundaryOfBinaryTree obj = new BoundaryOfBinaryTree();
//		TreeNode root = new TreeNode(1);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.right.left.left= new TreeNode(4);
		
		System.out.println(obj.boundaryOfBinaryTree(root));
	}
}
