
public class InorderSuccOrPred 
{
	TreeNode inorderSucc(TreeNode root, TreeNode p)
	{
		TreeNode succ = null;
		
		//Find min in right subtree
		if(p.right != null)
		{
			succ = p.right;
			while(succ.left != null)
			{
				succ = succ.left;
			}
			return succ;
		}
		
		while(root != null)
		{
			if(root.val > p.val)
			{
				succ = root;
				root = root.left;
			}
			else if(root.val < p.val)
			{
				root = root.right;
			}
			else
				break;
		}
		return succ;
	}
	
	TreeNode inorderPred(TreeNode root, TreeNode p)
	{
		TreeNode pred = null;

		//Find max in left subtree 
		if(p.left != null)
		{
			pred = p.left;
			while(pred.right != null)
			{
				pred = pred.right;
			}
			return pred;
		}
		
		while(root != null)
		{
			if(root.val > p.val)
			{
				root = root.left;
			}
			else if(root.val < p.val)
			{
				pred = root;
				root = root.right;
			}
			else
				break;
		}
		return pred;
	}
	
	public static void main(String[] args) 
	{

	}
}
