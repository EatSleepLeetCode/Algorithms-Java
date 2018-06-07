import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal 
{

	public List<List<Integer>> verticalOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> hdQueue = new LinkedList<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		queue.offer(root);
		hdQueue.offer(0);
		
		while(!queue.isEmpty())
		{
			TreeNode curr = queue.poll();
			int hd = hdQueue.poll();
			
			if(hd < min)
			{
				min = hd;
			}
			
			if(hd > max)
			{
				max = hd;
			}
			
			if(!map.containsKey(hd))
			{
				map.put(hd,  new ArrayList<Integer>());
			}
			
			map.get(hd).add(curr.val);
			
			if(curr.left != null)
			{
				queue.offer(curr.left);
				hdQueue.offer(hd - 1);
			}
			
			if(curr.right!= null)
			{
				queue.offer(curr.right);
				hdQueue.offer(hd + 1);
			}
		}
		
		for(int i = min; i <= max; i++)
		{
			result.add(map.get(i));
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
		
		VerticalOrderTraversal obj = new VerticalOrderTraversal();
		obj.verticalOrder(root);
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val)
	{
		this.val = val;
	}
}
