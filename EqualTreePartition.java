import java.util.HashMap;
import java.util.Map;

public class EqualTreePartition 
{
	boolean checkEqualTree(TreeNode root)
	{
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int sum = getSum(root, sumMap);
		
		if(sum == 0)
			return sumMap.getOrDefault(0, 0) > 1;
		
		return sum % 2 == 0 && sumMap.containsKey(sum / 2);
	}
	
	int getSum(TreeNode root, Map<Integer, Integer> sumMap)
	{
		if(root == null)
			return 0;
		
		int sum = root.val + getSum(root.left, sumMap) + getSum(root.right, sumMap);
		sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		return sum;
	}
	
	public static void main(String[] args) 
	{
		EqualTreePartition obj = new EqualTreePartition();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right= new TreeNode(10);
		root.right.left= new TreeNode(2);
		root.right.right= new TreeNode(3);
		
		System.out.println(obj.checkEqualTree(root));
	}
}
